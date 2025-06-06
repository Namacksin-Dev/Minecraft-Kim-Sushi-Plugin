package org.sushi.sushi.SushiCommands;

import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.sushi.sushi.Sushi;
import org.sushi.sushi.SushiSkills.SushiItemSkill;
import org.sushi.sushi.SushiSkills.SushiWeaponSkill;

public class SushiUpgradeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("해당 명령어는 플레이어만 사용할 수 있습니다.");
            return false;
        };

        Player player = (Player) sender;
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        CustomStack customStack = CustomStack.byItemStack(itemStack);
        if (CustomStack.byItemStack(itemStack) == null) {
            Sushi.sendErrorMessage(player, "해당 아이템은 강화할 수 없는 아이템 입니다.");
            player.closeInventory();
            return false;
        }
        if (!SushiWeaponSkill.hasSushiData(itemStack) && !SushiWeaponSkill.wasabiPowers.containsKey(customStack.getNamespacedID() + "1")) {
            Sushi.sendErrorMessage(player, "해당 아이템은 강화할 수 없는 아이템 입니다.");
            player.closeInventory();
            return false;
        }
        SushiItemSkill.sendUpgradeGui(player, itemStack);
        return true;
    }
}
