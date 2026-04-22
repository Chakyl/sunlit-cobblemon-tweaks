package io.github.chakyl.sunlitcobblemon.util;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.spawning.CobblemonWorldSpawnerManager;
import com.cobblemon.mod.common.api.spawning.SpawnBucket;
import com.cobblemon.mod.common.api.spawning.SpawnCause;
import com.cobblemon.mod.common.api.spawning.WorldSlice;
import com.cobblemon.mod.common.api.spawning.context.AreaSpawningContext;
import com.cobblemon.mod.common.api.spawning.context.SpawningContext;
import com.cobblemon.mod.common.api.spawning.detail.SpawnDetail;
import com.cobblemon.mod.common.api.spawning.spawner.PlayerSpawner;
import com.cobblemon.mod.common.api.spawning.spawner.SpawningArea;
import kotlin.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class GeneralUtils {

    public static Map<SpawnDetail, Float> getCobblemonSpawns(ServerLevel level, BlockPos pos, double range) {
        int configWorldSliceDiameter = 8;
        int configWorldSliceHeight = 16;
        ServerPlayer player = getNearPlayer(level, pos, range);
        if (player == null) return null;
        PlayerSpawner spawner = CobblemonWorldSpawnerManager.INSTANCE.getSpawnersForPlayers().get(player.getUUID());
        SpawnCause cause = new SpawnCause(spawner, getBucketByWeight(level), player);
        SpawningArea spawnArea = new SpawningArea(
                cause,
                level,
                (int) Math.ceil(pos.getX() - configWorldSliceDiameter / 2.0),
                (int) Math.ceil(pos.getY() - configWorldSliceHeight / 2.0),
                (int) Math.ceil(pos.getZ() - configWorldSliceDiameter / 2.0),
                configWorldSliceDiameter,
                configWorldSliceHeight,
                configWorldSliceDiameter
        );
        WorldSlice slice = spawner.getProspector().prospect(spawner, spawnArea);
        List<AreaSpawningContext> contexts = spawner.getResolver().resolve(spawner, spawner.getContextCalculators(), slice);

        return spawner.getSpawningSelector().getProbabilities(spawner, contexts);
    }

    public static Pair<SpawningContext, SpawnDetail> getSelectedSpawn(ServerLevel level, BlockPos pos, double range) {
        int configWorldSliceDiameter = 8;
        int configWorldSliceHeight = 16;
        ServerPlayer player = getNearPlayer(level, pos, range);
        if (player == null) return null;
        PlayerSpawner spawner = CobblemonWorldSpawnerManager.INSTANCE.getSpawnersForPlayers().get(player.getUUID());
        SpawnCause cause = new SpawnCause(spawner, getBucketByWeight(level), player);
        SpawningArea spawnArea = new SpawningArea(
                cause,
                level,
                (int) Math.ceil(pos.getX() - configWorldSliceDiameter / 2.0),
                (int) Math.ceil(pos.getY() - configWorldSliceHeight / 2.0),
                (int) Math.ceil(pos.getZ() - configWorldSliceDiameter / 2.0),
                configWorldSliceDiameter,
                configWorldSliceHeight,
                configWorldSliceDiameter
        );
        WorldSlice slice = spawner.getProspector().prospect(spawner, spawnArea);
        List<AreaSpawningContext> contexts = spawner.getResolver().resolve(spawner, spawner.getContextCalculators(), slice);

        return spawner.getSpawningSelector().select(spawner, contexts);
    }

    private static SpawnBucket getBucketByWeight(Level level) {
        List<SpawnBucket> buckets = Cobblemon.INSTANCE.getBestSpawner().getConfig().getBuckets();
        float weightTotal = 0;
        for (SpawnBucket bucket : buckets) {
            weightTotal += bucket.getWeight();
        }
        SpawnBucket chosenBucket = buckets.get(0);
        float roll = level.random.nextFloat() * (weightTotal - 0);
        for (SpawnBucket bucket : buckets) {
           if (roll < bucket.getWeight()) chosenBucket = bucket;
        }
        return chosenBucket;
    }

    private static ServerPlayer getNearPlayer(Level pLevel, BlockPos pPos, double range) {
        return (ServerPlayer) pLevel.getNearestPlayer((double) pPos.getX() + 0.5D, (double) pPos.getY() + 0.5D, (double) pPos.getZ() + 0.5D, range, true);
    }
}
