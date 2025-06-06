package org.sushi.sushi.SushiSkills;


import com.google.gson.Gson;
import dev.lone.itemsadder.api.CustomStack;
import dev.lone.itemsadder.api.ItemsAdder;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.sushi.sushi.Sushi;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SushiWeaponSkill implements Listener {
    private static final Gson gson = new Gson();
    private static final NamespacedKey KEY = new NamespacedKey("sushi_plugin", "wasabi_power_data");

    public static Map<String, WasabiPower> wasabiPowers = new ConcurrentHashMap<String, WasabiPower>();
    public static Map<UUID, Number> hasPlentyWasabi = new ConcurrentHashMap<>();

    @EventHandler
    public void onStart(ServerLoadEvent ev) {
        new WasabiPower("sushi_weapons:sushi_sword1",1,50,6.3,1.6,0.0,0.0,0.0,1,0,0,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:sushi_sword2",2,100,6.3,1.6,0.0,0.0,0.0,2,0,0,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:sushi_sword3",3,150,6.3,1.6,0.0,0.0,0.0,2,0,0,0,0,1,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:srirachasauce_sword1",1,50,6.45,1.55,0.0,0.0,0.0,0,0,1,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:srirachasauce_sword2",2,100,6.45,1.55,0.0,0.0,0.0,0,0,2,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:srirachasauce_sword3",3,150,6.45,1.55,0.0,0.0,0.0,1,0,3,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:tuna_sword1",1,50,6.63,1.54,0.0,0.0,0.0,0,0,1,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:tuna_sword2",2,100,6.63,1.54,0.0,0.0,0.0,1,0,1,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:tuna_sword3",3,150,6.63,1.54,0.0,0.0,0.0,1,0,1,2,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:salmon_sword1",1,50,6.12,1.6,0.0,0.0,0.0,0,0,0,0,0,1,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:salmon_sword2",2,100,6.12,1.6,0.0,0.0,0.0,0,0,0,0,0,2,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:salmon_sword3",3,150,6.12,1.6,0.0,0.0,0.0,0,0,0,0,0,3,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:flatfish_sword1",1,50,5.67,1.66,0.0,0.0,0.0,0,0,0,0,0,1,0,0,1,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:flatfish_sword2",2,100,5.67,1.66,0.0,0.0,0.0,0,0,0,0,0,1,0,0,2,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:flatfish_sword3",3,150,5.67,1.66,0.0,0.0,0.0,0,0,0,0,0,1,0,0,3,0,100,100,0,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:eel_sword1",1,50,5.89,1.63,1,0.0,0.0,0,0,0,0,0,0,1,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:eel_sword2",2,100,5.89,1.63,1,0.0,0.0,0,0,0,0,0,0,1,0,0,1,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:eel_sword3",3,150,5.89,1.63,1,0.0,0.0,0,0,0,0,0,0,1,0,0,1,100,100,1,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:shrimp_sword1",1,50,5.89,1.63,0,0.0,0.0,0,0,0,0,0,0,1,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:shrimp_sword2",2,100,5.89,1.63,0,0.0,0.0,0,0,0,0,0,0,2,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:shrimp_sword3",3,150,5.89,1.63,0,0.0,0.0,0,0,0,0,0,1,2,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:dragon_roll_sword1",1,100,7.55,1.6,0,0.0,0.0,3,0,0,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:dragon_roll_sword2",2,200,7.55,1.6,0,0.0,0.0,4,2,0,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:dragon_roll_sword3",3,300,7.55,1.6,0,0.0,0.0,5,4,0,0,0,0,0,0,0,2,100,100,0,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:sushi_waterball_sword1",1,50,6.87,1.71,0,0.0,0.0,0,0,0,0,1,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:sushi_waterball_sword2",2,100,6.87,1.71,0,0.0,0.0,0,0,0,0,2,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:sushi_waterball_sword3",3,150,6.87,1.71,0,0.0,0.0,0,0,0,0,2,0,0,1,0,0,100,100,0,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:sushi_rice_sword1",1,50,6.35,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,0,100,100,1,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:sushi_rice_sword2",2,100,6.35,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,1,100,100,1,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:sushi_rice_sword3",3,150,6.35,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,2,100,100,1,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:water_shark_sword1",1,100,7.55,1.6,0,0.0,0.0,0,0,2,0,0,0,0,0,0,0,100,100,0,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:water_shark_sword2",2,200,7.55,1.6,0,0.0,0.0,0,0,3,0,0,0,0,0,0,0,100,100,2,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:water_shark_sword3",3,300,7.55,1.6,0,0.0,0.0,0,0,3,0,1,0,0,0,0,0,100,100,4,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:egg_sushi_sword1",1,50,6.31,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,0,100,100,1,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:egg_sushi_sword2",2,100,6.31,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,0,100,100,2,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:egg_sushi_sword3",3,150,6.31,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,0,100,100,3,100,100,100,100,100,100,100,100,100);

        new WasabiPower("sushi_weapons:egg_sushi_sword1",1,50,6.31,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,0,100,100,1,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:egg_sushi_sword2",2,100,6.31,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,0,100,100,2,100,100,100,100,100,100,100,100,100);
        new WasabiPower("sushi_weapons:egg_sushi_sword3",3,150,6.31,1.6,0,0.0,0.0,0,0,0,0,0,0,0,0,0,0,100,100,3,100,100,100,100,100,100,100,100,100);

    }

    public static void saveWasabiPowerData(ItemStack item, WasabiPower wasabiPower) {
        ItemMeta meta = item.getItemMeta();
        //와사비 파워 데이터 불러오기
        if (meta == null) return;
        String json = gson.toJson(wasabiPower);
        meta.getPersistentDataContainer().set(KEY, PersistentDataType.STRING, json);
        item.setItemMeta(meta);
        List<String> array = new ArrayList<>();
        array.add("§r§8-----§7기본 스탯§8-----");
        if (wasabiPower.attackDamage != 0.0) {
            array.add("§r§7공격 피해§7: " + wasabiPower.attackDamage);
        }
        if (wasabiPower.attackSpeed != 0.0) {
            array.add("§r§7공격 속도§7: " + wasabiPower.attackSpeed);
        }
        if (wasabiPower.attackKnockback != 0.0) {
            array.add("§r§7공격 넉백§7: " + wasabiPower.attackKnockback);
        }
        if (wasabiPower.maxHealth != 0.0) {
            array.add("§r§7최대 채력§7: " + wasabiPower.maxHealth);
        }
        if (wasabiPower.movementSpeed != 0.0) {
            array.add("§r§7이동 속도§7: " + wasabiPower.movementSpeed);
        }
        array.add("§r§8-----§a와사비 §2파워 §f스탯§8-----");
        if (wasabiPower.hotness != 0) {
            array.add("§r§a매움§7: " + wasabiPower.hotness);
        }
        if (wasabiPower.wasabi_explosion != 0) {
            array.add("§r§a와사비 폭팔§7: " + wasabiPower.wasabi_explosion);
        }
        if(wasabiPower.bittertears != 0) {
            array.add("§r§a매운 눈물§7: " + wasabiPower.bittertears);
        }
        if (wasabiPower.wasabi_power != 0) {
            array.add("§r§a와사비 파워§7: " + wasabiPower.wasabi_power);
        }
        if (wasabiPower.spicy_counter != 0) {
            array.add("§r§a뜨거운 카운터§7: " + wasabiPower.spicy_counter);
        }
        if (wasabiPower.infinite_sushi != 0) {
            array.add("§r§a회전초밥§7: " + wasabiPower.infinite_sushi);
        }
        if (wasabiPower.burning_tongue != 0) {
            array.add("§r§a얼얼한 혀§7: " + wasabiPower.burning_tongue);
        }
        if (wasabiPower.plenty_wasabi != 0) {
            array.add("§r§a와사비 듬뿍§7: " + wasabiPower.plenty_wasabi);
        }
        if (wasabiPower.sushi_binding != 0) {
            array.add("§r§a초밥결속§7: " + wasabiPower.sushi_binding);
        }
        if (wasabiPower.resistance_wasabi != 0) {
            array.add("§r§a와사비 저항§7 : " + wasabiPower.resistance_wasabi);
        }
        if (wasabiPower.cheongyang_red_pepper != 0) {
            array.add("§r§a청양고추§7 : " + wasabiPower.cheongyang_red_pepper);
        }
        meta.setLore(array);
        item.setItemMeta(meta);
    };
    public static WasabiPower loadSushiData(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return null;

        String json = meta.getPersistentDataContainer().get(KEY, PersistentDataType.STRING);
        if (json == null) return null;

        return gson.fromJson(json, WasabiPower.class);
    }
    public static Boolean hasSushiData(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return null;

        return meta.getPersistentDataContainer().has(KEY, PersistentDataType.STRING);
    }
    public static class WasabiPower {

        String itemType;
        int upgrade;
        int upgradePrice;

        double attackDamage;
        double attackSpeed;
        double attackKnockback;
        double maxHealth;
        double movementSpeed;

        int hotness;
        int wasabi_explosion;
        int bittertears;
        int wasabi_power;
        int spicy_counter;
        int infinite_sushi;
        int burning_tongue;
        int plenty_wasabi;
        int sushi_binding;
        int resistance_wasabi;
        int cheongyang_red_pepper;

        final int max_hotness;
        final int max_wasabi_explosion;
        final int max_bittertears;
        final int max_wasabi_power;
        final int max_spicy_counter;
        final int max_infinite_sushi;
        final int max_burning_tongue;
        final int max_plenty_wasabi;
        final int max_sushi_binding;
        final int max_resistance_wasabi;
        final int max_cheongyang_red_pepper;

        public WasabiPower(String itemType, int upgrade, int upgradePrice, double attackDamage, double attackSpeed, double attackKnockback, double maxHealth, double movementSpeed, int hotness, int wasabi_explosion, int bittertears, int wasabi_power, int spicy_counter, int infinite_sushi, int sushi_binding, int burning_tongue, int plenty_wasabi, int resistance_wasabi, int max_hotness, int max_wasabi_explosion, int cheongyang_red_pepper, int max_bittertears, int max_wasabi_power, int max_spicy_counter, int max_infinite_sushi, int max_burning_tongue, int max_plenty_wasabi, int max_sushi_binding, int max_resistance_wasabi, int max_cheongyang_red_pepper) {
            this.itemType = itemType;
            this.upgrade = upgrade;
            this.upgradePrice = upgradePrice;

            this.attackDamage = attackDamage;
            this.attackSpeed = attackSpeed;
            this.attackKnockback = attackKnockback;
            this.maxHealth = maxHealth;
            this.movementSpeed = movementSpeed;

            this.hotness = hotness;
            this.wasabi_explosion = wasabi_explosion;
            this.bittertears = bittertears;
            this.wasabi_power = wasabi_power;
            this.spicy_counter = spicy_counter;
            this.infinite_sushi = infinite_sushi;
            this.sushi_binding = sushi_binding;
            this.burning_tongue = burning_tongue;
            this.plenty_wasabi = plenty_wasabi;
            this.resistance_wasabi = resistance_wasabi;
            this.max_hotness = max_hotness;
            this.max_wasabi_explosion = max_wasabi_explosion;
            this.cheongyang_red_pepper = cheongyang_red_pepper;
            this.max_bittertears = max_bittertears;
            this.max_wasabi_power = max_wasabi_power;
            this.max_spicy_counter = max_spicy_counter;
            this.max_infinite_sushi = max_infinite_sushi;
            this.max_burning_tongue = max_burning_tongue;
            this.max_plenty_wasabi = max_plenty_wasabi;
            this.max_sushi_binding = max_sushi_binding;
            this.max_resistance_wasabi = max_resistance_wasabi;
            this.max_cheongyang_red_pepper = max_cheongyang_red_pepper;
            SushiWeaponSkill.wasabiPowers.put(itemType, this);
        }
    }
    public void knockbackPlayer(Player attacker, LivingEntity target, double strength) {
        // 공격자와 대상 위치 벡터 차이
        org.bukkit.util.Vector knockbackDirection = target.getLocation().toVector().subtract(attacker.getLocation().toVector()).normalize();

        // 넉백 방향은 반대 방향 (뒤로 밀어내기)
        org.bukkit.util.Vector knockback = knockbackDirection.multiply(strength).setY(0.4); // Y 값은 약간 띄우기

        // 플레이어에 넉백 벡터 적용
        target.setVelocity(knockback);
    }
    private final Set<UUID> recentlyDamaged = ConcurrentHashMap.newKeySet();

    public void damageNearbyAndSpawnGreenParticles(LivingEntity damagedEntity, Player attacker, double radius, double damageAmount) {
        if (damageAmount <= 0) return;

        Location center = damagedEntity.getLocation();
        World world = center.getWorld();

        for (Entity nearby : world.getNearbyEntities(center, radius, radius, radius)) {
            if (nearby instanceof LivingEntity target) {
                if (target.equals(damagedEntity)) continue;
                if (target.equals(attacker)) continue;
                if (!target.isValid() || target.isDead()) continue;

                UUID targetId = target.getUniqueId();
                if (recentlyDamaged.contains(targetId)) continue;

                recentlyDamaged.add(targetId);
                try {
                    if (attacker != null) {
                        target.damage(damageAmount);
                    } else {
                        target.damage(damageAmount);
                    }
                } catch (IllegalArgumentException | IllegalStateException e) {
                    e.printStackTrace();
                }

                // 일정 시간 후 다시 피해 허용
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("sushi"), () -> {
                    recentlyDamaged.remove(targetId);
                }, 2L); // 2틱 후 제거 (1틱=50ms, 조정 가능)
            }
        }

        int particleCount = 100;
        for (int i = 0; i < particleCount; i++) {
            double offsetX = (Math.random() - 0.5) * 2 * radius;
            double offsetY = Math.random() * 2;
            double offsetZ = (Math.random() - 0.5) * 2 * radius;
            Location particleLoc = center.clone().add(offsetX, offsetY, offsetZ);

            world.spawnParticle(Particle.HAPPY_VILLAGER, particleLoc, 1, 0, 0, 0, 0.01);
        }
    }
    public void spawnTemporaryWaterAtPlayer(LivingEntity player, int durationSeconds) {
        Location loc = player.getLocation().getBlock().getLocation();
        Material original = loc.getBlock().getType();

        loc.getBlock().setType(Material.LAVA);

        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("sushi"), () -> {
            loc.getBlock().setType(original);
        }, durationSeconds * 5L);
    }
    @EventHandler
    public void inAttack(EntityDamageByEntityEvent ev) {
        if (!(ev.getDamager() instanceof Player) || !(ev.getEntity() instanceof LivingEntity)) return;
        Player damagingPlayer = (Player) ev.getDamager();
        LivingEntity damagedEntity = (LivingEntity) ev.getEntity();
        ItemStack itemStack = damagingPlayer.getInventory().getItemInMainHand();
        if (CustomStack.byItemStack(itemStack) == null) {
            return;
        }
        if (!SushiWeaponSkill.hasSushiData(itemStack)) return;
        WasabiPower wasabiPower = loadSushiData(itemStack);
        if (damagedEntity instanceof Player) {
            Player target = (Player) damagedEntity;
            ItemStack item = target.getInventory().getItemInMainHand();
            if (hasSushiData(item)) {
                WasabiPower wasabiPower1 = loadSushiData(item);
                if (wasabiPower1.resistance_wasabi != 0) {
                    if (SushiItemSkill.ProbabilityUtil.isSuccess(0.045 * wasabiPower.resistance_wasabi)) {
                        Sushi.sendMessage(damagingPlayer, "상대의 와사비 저항 효과가 발동 되었습니다!");
                        Sushi.sendMessage(target, "와사비 저항 효과가 발동 되었습니다!");
                        return;
                    }
                }
                if (wasabiPower1.sushi_binding != 0) {
                    if (SushiItemSkill.ProbabilityUtil.isSuccess(0.005 * wasabiPower.sushi_binding)) {
                        target.getWorld().dropItem(target.getLocation(), ItemsAdder.getCustomItem("sushi_items:sushi"));
                        Sushi.sendMessage(target, "초밥 결속 효과가 발동 되었습니다!");
                    }
                }
            }
        }
        if (wasabiPower.hotness != 0) {
            knockbackPlayer(damagingPlayer, damagedEntity, wasabiPower.hotness*0.2);
            damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, wasabiPower.hotness*30 + 40, 1,false));
            ParticleUtils.spawnVillagerHappyGreen(damagedEntity);
            Sushi.sendMessage(damagingPlayer, "매움 효과가 발동 되었습니다!");
        }
        if (wasabiPower.wasabi_explosion != 0) {
            damageNearbyAndSpawnGreenParticles(damagedEntity, damagingPlayer, 1.0+wasabiPower.wasabi_explosion*0.25, 1.0*wasabiPower.wasabi_explosion);
            Sushi.sendMessage(damagingPlayer, "와사비 폭팔 효과가 발동 되었습니다!");
        }
        if(wasabiPower.bittertears != 0) {
            if (SushiItemSkill.ProbabilityUtil.isSuccess(0.2 * wasabiPower.bittertears)) {
                damagedEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, wasabiPower.hotness*30 + 40, 1,false));
                damagedEntity.getWorld().spawnParticle(Particle.DRIPPING_LAVA, damagedEntity.getLocation().add(0, 1, 0), 10, 0.3, 0.5, 0.3, 0.1);
                Sushi.sendMessage(damagingPlayer, "매운 눈물 효과가 발동 되었습니다!");
            }
        }
        if (wasabiPower.wasabi_power != 0) {
            if (SushiItemSkill.ProbabilityUtil.isSuccess(0.10 * wasabiPower.wasabi_power)) {
                damagingPlayer.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, wasabiPower.wasabi_power*40, 0, false));
                damagingPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, wasabiPower.wasabi_power*40, 0, false));
                Sushi.sendMessage(damagingPlayer, "와사비 파워 효과가 발동 되었습니다!");
            }
        }
        if (wasabiPower.spicy_counter != 0) {
            setFireForDuration(damagedEntity,2+0.2*wasabiPower.spicy_counter);
            damagedEntity.damage(0.6*wasabiPower.spicy_counter);
            Sushi.sendMessage(damagingPlayer, "뜨거운 카운터 효과가 발동 되었습니다!");
        }
        if (wasabiPower.infinite_sushi != 0) {
            if (SushiItemSkill.ProbabilityUtil.isSuccess(0.005 * wasabiPower.infinite_sushi)) {
                damagingPlayer.getWorld().dropItem(damagingPlayer.getLocation(), ItemsAdder.getCustomItem("sushi_items:sushi"));
                Sushi.sendMessage(damagingPlayer, "회전초밥 효과가 발동 되었습니다!");
            }
        }
        if (wasabiPower.burning_tongue != 0) {
            damageOverTime(Bukkit.getPluginManager().getPlugin("sushi"), damagedEntity, 3.0+0.5*wasabiPower.burning_tongue, 1,10);
            Sushi.sendMessage(damagingPlayer, "얼얼한 혀 효과가 발동 되었습니다!");
        }
        if (wasabiPower.plenty_wasabi != 0) {
            if (damagedEntity instanceof Player) {
                hasPlentyWasabi.put(damagedEntity.getUniqueId(), 1+0.5*wasabiPower.plenty_wasabi);
                Sushi.sendMessage(damagingPlayer, "와사비 듬뿍 효과가 효과가 발동 되었습니다!");
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("sushi"), () -> {
                    hasPlentyWasabi.remove(damagedEntity.getUniqueId());
                }, 60L * wasabiPower.plenty_wasabi);
            }

        }
        if (wasabiPower.cheongyang_red_pepper != 0) {
            damagedEntity.damage(wasabiPower.cheongyang_red_pepper);
            Sushi.sendMessage(damagingPlayer, "청양고추 효과가 발동 되었습니다!");
        }
    }
    public static void setFireForDuration(Entity entity, double durationSeconds) {
        if (entity == null || !entity.isValid()) return;

        int durationTicks = (int)(durationSeconds * 20); // 1초 = 20틱
        entity.setFireTicks(durationTicks); // 처음에 불 붙이기 (틱 단위)

        new BukkitRunnable() {
            int ticksPassed = 0;

            @Override
            public void run() {
                if (!entity.isValid() || ticksPassed >= durationTicks) {
                    entity.setFireTicks(0); // 불 끄기
                    cancel();
                    return;
                }
                // 지속적으로 불 붙이기 위해 다시 설정 (플레이어 움직이면 꺼질 수 있어서)
                entity.setFireTicks(durationTicks - ticksPassed);
                ticksPassed++;
            }
        }.runTaskTimer(Bukkit.getPluginManager().getPlugin("sushi"), 0L, 1L);
    }
    public static void damageOverTime(Plugin plugin, LivingEntity target, double totalSeconds, double damagePerTick, long intervalTicks) {
        if (totalSeconds <= 0 || damagePerTick <= 0 || intervalTicks <= 0) return;

        long totalTicks = (long) (totalSeconds * 20);
        long iterations = totalTicks / intervalTicks;

        new BukkitRunnable() {
            long count = 0;

            @Override
            public void run() {
                if (count >= iterations || !target.isValid() || target.isDead()) {
                    cancel();
                    return;
                }

                // 대미지 입히기 (원인 없이)
                target.damage(damagePerTick);

                // 주민 행복 파티클 생성
                Location loc = target.getLocation().add(0, 1, 0);
                loc.getWorld().spawnParticle(Particle.HAPPY_VILLAGER, loc, 5, 0.3, 0.5, 0.3, 0.1);

                count++;
            }
        }.runTaskTimer(plugin, 0L, intervalTicks);
    }

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        Material item = event.getItem().getType();

        if (item.isEdible()) {
            if (hasPlentyWasabi.containsKey(player.getUniqueId())) {
                Number damageAmount = hasPlentyWasabi.get(player.getUniqueId());
                player.damage(damageAmount.doubleValue()*0.5+1);
                Sushi.sendMessage(player, "와사비 듬뿍 효과로 인해 음식을 섭취해서 피해를 입었습니다!");
            }
        }
    }

    public static class ParticleUtils {

        // 1) VILLAGER_HAPPY 파티클 (초록빛 느낌)
        public static void spawnVillagerHappyGreen(Entity entity) {
            Location loc = entity.getLocation();
            World world = loc.getWorld();
            if (world == null) return;

            world.spawnParticle(Particle.HAPPY_VILLAGER, loc, 10, 0.5, 1, 0.5, 0.1);
        }
        public static void spawnParticlesAtPlayer(Player player, Particle particle, int durationTicks, int count) {
            Location loc = player.getLocation();

            BukkitTask task = Bukkit.getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("sushi"), new Runnable() {
                int ticksPassed = 0;

                @Override
                public void run() {
                    if (ticksPassed >= durationTicks || !player.isOnline()) {
                        this.cancel();
                        return;
                    }
                    player.getWorld().spawnParticle(particle, player.getLocation(), count, 0, 0, 0, 0);
                    ticksPassed++;
                }

                // 취소용 메서드
                private void cancel() {
                    // BukkitTask 취소는 외부에서 하는게 보통이라 따로 구현 필요할 수도 있음
                }
            }, 0L, 1L); // 1틱마다 실행
        }
    }
}
