package io.github.chakyl.sunlitcobblemon.item;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.permission.CobblemonPermission;
import com.cobblemon.mod.common.api.permission.CobblemonPermissions;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import com.cobblemon.mod.common.api.storage.pc.PCStore;
import com.cobblemon.mod.common.api.storage.pc.link.PCLink;
import com.cobblemon.mod.common.api.storage.pc.link.PCLinkManager;
import com.cobblemon.mod.common.api.storage.pc.link.PermissiblePcLink;
import com.cobblemon.mod.common.battles.BattleRegistry;
import com.cobblemon.mod.common.net.messages.client.storage.pc.OpenPCPacket;
import dev.zanckor.cobblemonrider.CobblemonRider;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class PocketPCItem extends Item {

    public PocketPCItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.playSound(CobblemonSounds.PC_ON, 1.0F, 1.0F);
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            if (BattleRegistry.INSTANCE.getBattleByParticipatingPlayer((ServerPlayer) player) != null) {
                player.sendSystemMessage(Component.translatable("message.sunlit_cobblemon.in_battle").withStyle(ChatFormatting.RED));
                return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
            }
            PCStore pc = null;
            try {
                pc = Cobblemon.INSTANCE.getStorage().getPC(serverPlayer.getUUID());
            } catch (NoPokemonStoreException e) {
                throw new RuntimeException(e);
            }
            if (pc == null) return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
            PCLinkManager.INSTANCE.addLink(new PCLink(pc, serverPlayer.getUUID()));
            OpenPCPacket packet = new OpenPCPacket(pc.getUuid());
            packet.sendToPlayer(serverPlayer);

        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}