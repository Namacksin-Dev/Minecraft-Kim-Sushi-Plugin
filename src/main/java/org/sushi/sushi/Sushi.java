package org.sushi.sushi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.sushi.sushi.DataBase.JsonDataBase;
import org.sushi.sushi.SushiCommands.SushiCommand;
import org.sushi.sushi.SushiCommands.SushiMainCommand;
import org.sushi.sushi.SushiCommands.SushiStoreCommand;
import org.sushi.sushi.SushiCommands.SushiUpgradeCommand;
import org.sushi.sushi.SushiSkills.SushiItemSkill;
import org.sushi.sushi.SushiSkills.SushiWeaponSkill;

import java.io.File;

public final class Sushi extends JavaPlugin {
    public static JsonDataBase WasabiGaugeDataBase;
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("김초밥 플러그인이 작동 되었습니다.");
        SushiItemSkill sushiItemSkill = new SushiItemSkill();
        SushiWeaponSkill sushiWeaponSkill = new SushiWeaponSkill();
        Bukkit.getPluginManager().registerEvents(sushiItemSkill, this);
        Bukkit.getPluginManager().registerEvents(sushiWeaponSkill, this);
        Bukkit.getPluginCommand("김초밥매뉴").setExecutor(new SushiMainCommand());
        Bukkit.getPluginCommand("김초밥").setExecutor(new SushiCommand());
        Bukkit.getPluginCommand("김초밥상점").setExecutor(new SushiStoreCommand());
        Bukkit.getPluginCommand("김초밥강화").setExecutor(new SushiUpgradeCommand());

        if (!getDataFolder().exists()) {
            getLogger().info("데이터 폴더가 생성 되었습니다.");
            getDataFolder().mkdirs();
        }
        WasabiGaugeDataBase = new JsonDataBase(new File(getDataFolder(), "wasabi_gauge.json"));
        WasabiGaugeDataBase.load();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("김초밥 플러그인이 작동 중지 되었습니다.");
        WasabiGaugeDataBase.save();
    }
    public void log(String msg) {
        Bukkit.getLogger().info(msg);
    };
    public static final String prefix = "§8[ §2김§a초§f밥 §e플러그인 §8]§r ";
    public static void sendErrorMessage(Player player, String message) {
        player.sendMessage(prefix + "§c§a오§f류§r : " + message);
    }
    public static void sendMessage(Player player, String message) {
        player.sendMessage(prefix + "§2시§a스§f템§r : " + message);
    }
    public static long getWasabiGauge(Player player) {
        String key = player.getUniqueId().toString();
        if (!WasabiGaugeDataBase.has(key)) {
            WasabiGaugeDataBase.set(key, 0L);
        }
        Object rawValue = WasabiGaugeDataBase.get(key);
        long gauge = 0L;
        if (rawValue instanceof Number) {
            gauge = ((Number) rawValue).longValue();  // ← 안전한 변환
        }
        return gauge;
    };
    public static void setWasabiGauge(Player player, long amount) {
        String key = player.getUniqueId().toString();
        if (!WasabiGaugeDataBase.has(key)) {
            WasabiGaugeDataBase.set(key, 0L);
        }
        WasabiGaugeDataBase.set(key, amount);
    };
    public static void removeWasabiGauge(Player player, long amount) {
        String key = player.getUniqueId().toString();
        if (!WasabiGaugeDataBase.has(key)) {
            WasabiGaugeDataBase.set(key, 0L);
        }
        Object rawValue = WasabiGaugeDataBase.get(key);
        long gauge = 0L;
        if (rawValue instanceof Number) {
            gauge = ((Number) rawValue).longValue();  // ← 안전한 변환
        }
        WasabiGaugeDataBase.set(key, gauge-amount);
    };
    public static void addWasabiGauge(Player player, long amount) {
        String key = player.getUniqueId().toString();
        if (!WasabiGaugeDataBase.has(key)) {
            WasabiGaugeDataBase.set(key, 0L);
        }
        Object rawValue = WasabiGaugeDataBase.get(key);
        long gauge = 0L;
        if (rawValue instanceof Number) {
            gauge = ((Number) rawValue).longValue();  // ← 안전한 변환
        }
        WasabiGaugeDataBase.set(key, gauge+amount);
    };

}