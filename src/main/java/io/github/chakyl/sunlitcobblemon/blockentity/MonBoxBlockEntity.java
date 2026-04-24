package io.github.chakyl.sunlitcobblemon.blockentity;

import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.api.spawning.context.SpawningContext;
import com.cobblemon.mod.common.api.spawning.detail.PokemonSpawnDetail;
import com.cobblemon.mod.common.api.spawning.detail.SpawnAction;
import com.cobblemon.mod.common.api.spawning.detail.SpawnDetail;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import io.github.chakyl.sunlitcobblemon.block.MonBoxBlock;
import io.github.chakyl.sunlitcobblemon.registry.SunlitCobblemonRegistry;
import kotlin.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import static io.github.chakyl.sunlitcobblemon.util.GeneralUtils.getSelectedSpawn;

public class MonBoxBlockEntity extends BlockEntity {
    private int ACTIVATION_RANGE = 14;
    private int MAX_NEARBY_ENTITIES = 16;
    protected String pokemonType = "";
    private int pokemonCount = 5;
    private int cooldown = 0;
    private int dispensedPokemons = 0;

    public MonBoxBlockEntity(BlockPos pos, BlockState state) {
        super(SunlitCobblemonRegistry.BlockEntityRegistry.MON_BOX.get(), pos, state);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide()) return;
        BlockPos facingPos = pos.relative(state.getValue(DispenserBlock.FACING));
        if (level.getGameTime() % 4 == 0 && dispensedPokemons == 0 && !level.getBlockState(facingPos).isSolid() && isNearPlayer(level, pos)) {
            int day = (int) (Math.floor((double) level.dayTime() / 24000) + 1);
            if (day != cooldown) {
                int nearbyPokemons = level.getEntitiesOfClass(PokemonEntity.class, (new AABB(pos.getX(), pos.getY(), pos.getZ(), (pos.getX() + 1), (pos.getY() + 1), (pos.getZ() + 1))).inflate(1)).size();
                if (nearbyPokemons < this.MAX_NEARBY_ENTITIES) {
                    BlockState newState = state.setValue(MonBoxBlock.OPEN, true);
                    this.cooldown = day;
                    level.setBlockAndUpdate(pos, newState);
                    setChanged();
                }
            }
        }
        if (level.getGameTime() % 4 == 0 && state.getValue(MonBoxBlock.OPEN)) {
            Pair<SpawningContext, SpawnDetail> spawnPossibilities = getSelectedSpawn((ServerLevel) level, pos, (double) this.ACTIVATION_RANGE);
            if (spawnPossibilities != null) {
                SpawnAction<?> a = spawnPossibilities.getSecond().doSpawn(spawnPossibilities.getFirst());
                PokemonSpawnDetail detail = (PokemonSpawnDetail) spawnPossibilities.getSecond();
                PokemonProperties pokemonProperties = detail.getPokemon();
                PokemonEntity entity = pokemonProperties.createEntity(level);
                int randomNum = level.getRandom().nextIntBetweenInclusive(detail.getDerivedLevelRange().getStart(), detail.getDerivedLevelRange().getEndInclusive());
                entity.getPokemon().setLevel(randomNum);
                if (entity != null) {
                    Direction direction = state.getValue(MonBoxBlock.FACING);
                    double d0 = facingPos.getX() + 0.5;
                    double d1 = facingPos.getY();
                    double d2 = facingPos.getZ() + 0.5;
                    RandomSource randomsource = level.random;
                    double d3 = randomsource.triangle(direction.getStepX(), 0.11485000000000001D);
                    double d4 = randomsource.triangle(direction.getStepY(), 0.11485000000000001D);
                    double d5 = randomsource.triangle(direction.getStepZ(), 0.11485000000000001D);
                    entity.push(d3, d4, d5);
                    entity.moveTo(d0, d1, d2, level.random.nextFloat() * 360.0F, 0.0F);
                    if (level.addFreshEntity(entity)) {
                        entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 80, 1, true, false));
                        this.dispensedPokemons++;
                    }

                }

            }


        }
        if (this.dispensedPokemons == pokemonCount) {
            this.dispensedPokemons = 0;
            BlockState newState = state.setValue(MonBoxBlock.OPEN, false);
            level.setBlockAndUpdate(pos, newState);
            setChanged();
        }
    }

    private boolean isNearPlayer(Level pLevel, BlockPos pPos) {
        return pLevel.hasNearbyAlivePlayer((double) pPos.getX() + 0.5D, (double) pPos.getY() + 0.5D, (double) pPos.getZ() + 0.5D, (double) this.ACTIVATION_RANGE);
    }


    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("cooldown", this.cooldown);
        tag.putInt("pokemonCount", this.pokemonCount);
        tag.putInt("dispensedPokemons", this.dispensedPokemons);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.cooldown = tag.getInt("cooldown");
        this.pokemonCount = tag.getInt("pokemonCount");
        this.dispensedPokemons = tag.getInt("dispensedPokemons");
    }

    public void setPokemonType(String type) {
        this.pokemonType = type;
    }

    public String getPokemonType() {
        return this.pokemonType;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public int setPokemonCount(int count) {
        return this.pokemonCount = count;
    }

    public int getPokemonCount() {
        return this.pokemonCount;
    }
}