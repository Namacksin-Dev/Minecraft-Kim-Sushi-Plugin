package org.sushi.sushi.SushiCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.sushi.sushi.SushiSkills.SushiItemSkill;

public class SushiStoreCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("해당 명령어는 플레이어만 사용할 수 있습니다.");
            return false;
        };

        Player player = (Player) sender;
        SushiItemSkill.sendStoreGui(player,1);
        return true;
    }
}
