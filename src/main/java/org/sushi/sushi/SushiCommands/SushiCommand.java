package org.sushi.sushi.SushiCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.sushi.sushi.Sushi;

public class SushiCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("해당 명령어는 플레이어만 사용할 수 있습니다.");
            return false;
        };

        Player player = (Player) sender;
        Sushi.sendMessage(player, "§8[ §2김§a초§f밥 §e플러그인 §8]§r");
        Sushi.sendMessage(player, "§7김초밥 상점에서 §e김초밥 아이템§7을 구매할 수 있어요!");
        Sushi.sendMessage(player, "§7김초밥을 열면 다양한 §d보상§7이 무작위로 등장합니다.");
        Sushi.sendMessage(player, "§7획득한 김초밥 아이템은 §a와사비 게이지§7를 통해 §6업그레이드§7할 수 있어요.");
        Sushi.sendMessage(player, "§7업그레이드된 김초밥 아이템은 §c와사비 파워§7가 잠금 해제되어 전투에 강력한 이점을 제공합니다.");
        Sushi.sendMessage(player, "§8『김초밥을 이용하여 전장을 지배하세요!』");
        return true;
    }
}
