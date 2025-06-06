package org.sushi.sushi.SushiSkills;

import dev.lone.itemsadder.api.ItemsAdder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import org.sushi.sushi.Sushi;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SushiItemSkill implements Listener {
    public static Map<String, SushiStoreItem> sushiStoreItems = new ConcurrentHashMap<String, SushiStoreItem>();
    static class SushiStoreItem {
        String name;
        String description;
        int wasabi_gauge_price;
        int index;
        ItemStack itemStack;
        SushiStoreItem(String name, String description, int wasabi_gauge_price, int index, ItemStack itemStack) {
            this.name = name;
            this.description = description;
            this.wasabi_gauge_price = wasabi_gauge_price;
            this.itemStack = itemStack;
            this.index = index;
            sushiStoreItems.put(name, this);
        };
    }
    public static Map<Number, SushiOpenReward> sushiOpenReward = new ConcurrentHashMap<Number, SushiOpenReward>();
    static class SushiOpenReward {
        ItemStack itemStack;
        int amount;
        int rare;
        String name;
        SushiOpenReward(ItemStack itemStack, int amount, int rare, String name) {
            this.itemStack = itemStack;
            this.amount = amount;
            this.rare = rare;
            this.name = name;
        };
    };
    @EventHandler
    public void startServer(ServerLoadEvent ev) {
        sushiOpenReward.put(1, new SushiOpenReward(new ItemStack(Material.IRON_INGOT), 5, 1, "§e철 주괴 5개"));
        sushiOpenReward.put(2, new SushiOpenReward(new ItemStack(Material.GOLD_INGOT), 7, 1,"§e금 주괴 7개"));
        sushiOpenReward.put(3, new SushiOpenReward(new ItemStack(Material.COAL), 10, 1, "§e석탄 10개"));
        sushiOpenReward.put(4, new SushiOpenReward(new ItemStack(Material.LAPIS_LAZULI), 15, 1, "§e청금석 15개"));
        sushiOpenReward.put(5, new SushiOpenReward(new ItemStack(Material.REDSTONE), 17, 1, "§e레드스톤 15개"));
        sushiOpenReward.put(6, new SushiOpenReward(new ItemStack(Material.DIAMOND), 1, 1, "§e다이아몬드 1개"));
        sushiOpenReward.put(7, new SushiOpenReward(new ItemStack(Material.EMERALD), 1, 1, "§e에메랄드 1개"));
        sushiOpenReward.put(8, new SushiOpenReward(new ItemStack(Material.BREAD), 20, 1, "§e빵 20개"));
        sushiOpenReward.put(9, new SushiOpenReward(new ItemStack(Material.OAK_LOG), 15, 1, "§e참나무 원목 15개"));
        sushiOpenReward.put(10, new SushiOpenReward(new ItemStack(Material.COBBLESTONE), 13, 1, "§e조약돌 13개"));
        sushiOpenReward.put(11, new SushiOpenReward(new ItemStack(Material.COPPER_INGOT), 9, 1, "§e구리 주괴 9개"));
        sushiOpenReward.put(12, new SushiOpenReward(new ItemStack(Material.BOOK), 15, 1, "§e책 15개"));
        sushiOpenReward.put(13, new SushiOpenReward(new ItemStack(Material.COOKED_BEEF), 15, 1, "§e구운 쇠고기 15개"));
        sushiOpenReward.put(14, new SushiOpenReward(new ItemStack(Material.COOKED_CHICKEN), 17, 1, "§e구운 닭고기 17개"));
        sushiOpenReward.put(15, new SushiOpenReward(new ItemStack(Material.BOW), 1, 1, "§e활 1개"));
        sushiOpenReward.put(16, new SushiOpenReward(new ItemStack(Material.FIREWORK_ROCKET), 12, 1, "§e폭죽 로켓 12개"));
        sushiOpenReward.put(17, new SushiOpenReward(new ItemStack(Material.COOKED_MUTTON), 17, 1, "§e구운 양고기 17개"));
        sushiOpenReward.put(18, new SushiOpenReward(new ItemStack(Material.COOKED_PORKCHOP), 16, 1, "§e구운 돼지고기 16개"));

        sushiOpenReward.put(19, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:sushi_sword"), 1, 1, "§e김초밥 검"));
        sushiOpenReward.put(20, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:srirachasauce_sword"), 1, 1, "§e크리라차소스 검"));
        sushiOpenReward.put(21, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:tuna_sword"), 1, 1, "§e참치 검"));
        sushiOpenReward.put(22, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:salmon_sword"), 1, 1, "§e연어 검"));
        sushiOpenReward.put(23, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:flatfish_sword"), 1, 1, "§e방어 검"));
        sushiOpenReward.put(24, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:eel_sword"), 1, 1, "§e장어 검"));
        sushiOpenReward.put(25, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:shrimp_sword"), 1, 1, "§e새우 검"));
        sushiOpenReward.put(26, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:sushi_waterball_sword"), 1, 1, "§e초밥 워터볼 검"));
        sushiOpenReward.put(27, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:sushi_rice_sword"), 1, 1, "§e초밥 밥알 검"));
        sushiOpenReward.put(29, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:egg_sushi_sword"), 1, 1, "§e계란 초밥 검"));
        sushiOpenReward.put(30, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:mackerel_sword"), 1, 1, "§e고등어 검"));
        sushiOpenReward.put(31, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:jellyfish_sushi_sword"), 1, 1, "§e해파리 초밥 검"));
        sushiOpenReward.put(32, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:cucumber_wasabi_sword"), 1, 1, "§e오이 와사비 검"));
        sushiOpenReward.put(33, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:yellowtail_sword"), 1, 1, "§e방어 검"));
        sushiOpenReward.put(34, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:squid_sushi_sword"), 1, 1, "§e오징어 초밥 검"));

        sushiOpenReward.put(35, new SushiOpenReward(new ItemStack(Material.DIAMOND), 5, 2, "§e다이아몬드 5개"));
        sushiOpenReward.put(36, new SushiOpenReward(new ItemStack(Material.NETHERITE_INGOT), 1, 2, "§e네더라이트 주괴 1개"));
        sushiOpenReward.put(37, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:dragon_roll_sword"), 1, 2, "§e드래곤 롤 검"));
        sushiOpenReward.put(38, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:water_shark_sword"), 1, 2, "§e청상아리 검"));

        sushiOpenReward.put(39, new SushiOpenReward(new ItemStack(Material.ELYTRA), 1, 3, "§e걷날개 1개"));
        sushiOpenReward.put(40, new SushiOpenReward(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE), 1, 3, "§e마법이 부여된 황금 사과 1개"));
        sushiOpenReward.put(41, new SushiOpenReward(new ItemStack(Material.GOLDEN_APPLE), 10, 3, "§e황금 사과 10개"));
        sushiOpenReward.put(42, new SushiOpenReward(new ItemStack(Material.TOTEM_OF_UNDYING), 1, 3, "§e불사의 토템 1개"));
        sushiOpenReward.put(43, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:suisame_sword"), 1, 3, "§e스이사메 검"));
        sushiOpenReward.put(44, new SushiOpenReward(ItemsAdder.getCustomItem("sushi_weapons:super_king_sushi_sword"), 1, 3, "§e슈퍼 킹 초밥 검"));

        new SushiStoreItem("§a김초밥 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,0, ItemsAdder.getCustomItem("sushi_weapons:sushi_sword"));
        new SushiStoreItem("§a스리라차소스 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,1, ItemsAdder.getCustomItem("sushi_weapons:srirachasauce_sword"));
        new SushiStoreItem("§a참치 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,2, ItemsAdder.getCustomItem("sushi_weapons:tuna_sword"));
        new SushiStoreItem("§a연어 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,3, ItemsAdder.getCustomItem("sushi_weapons:salmon_sword"));
        new SushiStoreItem("§a광어 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,4, ItemsAdder.getCustomItem("sushi_weapons:flatfish_sword"));
        new SushiStoreItem("§a장어 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,5, ItemsAdder.getCustomItem("sushi_weapons:eel_sword"));
        new SushiStoreItem("§2새우 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 100,6, ItemsAdder.getCustomItem("sushi_weapons:shrimp_sword"));
        new SushiStoreItem("§c드래곤 롤 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 150,7, ItemsAdder.getCustomItem("sushi_weapons:dragon_roll_sword"));
        new SushiStoreItem("§a초밥 워터볼 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,8, ItemsAdder.getCustomItem("sushi_weapons:sushi_waterball_sword"));
        new SushiStoreItem("§a초밥 밥알 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,9, ItemsAdder.getCustomItem("sushi_weapons:sushi_rice_sword"));
        new SushiStoreItem("§c청상아리 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 150,10, ItemsAdder.getCustomItem("sushi_weapons:water_shark_sword"));
        new SushiStoreItem("§a계란 초밥 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,11, ItemsAdder.getCustomItem("sushi_weapons:egg_sushi_sword"));
        new SushiStoreItem("§a고등어 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,12, ItemsAdder.getCustomItem("sushi_weapons:mackerel_sword"));
        new SushiStoreItem("§a해파리 초밥 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,13, ItemsAdder.getCustomItem("sushi_weapons:jellyfish_sushi_sword"));
        new SushiStoreItem("§a오이 와사비 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,14, ItemsAdder.getCustomItem("sushi_weapons:cucumber_wasabi_sword"));
        new SushiStoreItem("§a방어 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,15, ItemsAdder.getCustomItem("sushi_weapons:yellowtail_sword"));
        new SushiStoreItem("§e스이사메 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 1000,16, ItemsAdder.getCustomItem("sushi_weapons:suisame_sword"));
        new SushiStoreItem("§a오징어 초밥 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 50,17, ItemsAdder.getCustomItem("sushi_weapons:squid_sushi_sword"));
        new SushiStoreItem("§e슈퍼 킹 초밥 검", "§e김초밥 보상에서 획득 가능한 아이템 입니다.", 1000,18, ItemsAdder.getCustomItem("sushi_weapons:super_king_sushi_sword"));
        new SushiStoreItem("§a문어 초밥 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,19, ItemsAdder.getCustomItem("sushi_weapons:octopus_sushi_sword"));
        new SushiStoreItem("§a소고기 초밥 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,20, ItemsAdder.getCustomItem("sushi_weapons:beef_sushi_sword"));
        new SushiStoreItem("§a붕장어 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,21, ItemsAdder.getCustomItem("sushi_weapons:congerfish_sword"));
        new SushiStoreItem("§a도미 초밥 검 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,22, ItemsAdder.getCustomItem("sushi_weapons:seabream_sushi_sword"));
        new SushiStoreItem("§a전갱이 초밥 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,23, ItemsAdder.getCustomItem("sushi_weapons:horsemackerel_sushi_sword"));
        new SushiStoreItem("§a성게 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,24, ItemsAdder.getCustomItem("sushi_weapons:seaurchin_sword"));
        new SushiStoreItem("§a연어알 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,25, ItemsAdder.getCustomItem("sushi_weapons:salmonroe_sword"));
        new SushiStoreItem("§a참치뱃살 초밥 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,26, ItemsAdder.getCustomItem("sushi_weapons:tunabellymeat_sushi_sword"));
        new SushiStoreItem("§a간장새우 초밥 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,27, ItemsAdder.getCustomItem("sushi_weapons:shrimp_with_soysauce_sushi_sword"));
        new SushiStoreItem("§a관자초밥 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,28, ItemsAdder.getCustomItem("sushi_weapons:scallops_sushi_sword"));
        new SushiStoreItem("§a유부초밥 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,29, ItemsAdder.getCustomItem("sushi_weapons:inari_sushi_sword"));
        new SushiStoreItem("§a와사비 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,30, ItemsAdder.getCustomItem("sushi_weapons:wasabi_sword"));
        new SushiStoreItem("§a김 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,31, ItemsAdder.getCustomItem("sushi_weapons:laver_sword"));
        new SushiStoreItem("§a간장 검", "§e김초밥 상점에서 획득 가능한 아이템 입니다.", 70,32, ItemsAdder.getCustomItem("sushi_weapons:soysauce_sword"));















    };
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Action action = event.getAction();

        if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemStack item = event.getItem();

            if (item != null && item.getType() != Material.AIR) {
                if (CustomStack.byItemStack(item) != null) {
                    CustomStack stack = CustomStack.byItemStack(item);
                    if (stack.getNamespacedID().equals("sushi_items:sushi")) {
                        Sushi.sendMessage(player, "김초밥 매뉴를 열었습니다.");
                        sendMainGui(player);
                    }
                }
            }
        }
    }
    public static boolean hasCustomItem(Player player, String namespacedId) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null || item.getType().isAir()) continue;

            CustomStack custom = CustomStack.byItemStack(item);
            if (custom != null && custom.getNamespacedID().equalsIgnoreCase(namespacedId)) {
                return true;
            }
        }
        return false;
    }
    public static int clearCustomItem(Player player, String namespacedId, int amountToRemove) {
        if (amountToRemove <= 0) return 0;

        int removed = 0;
        ItemStack[] contents = player.getInventory().getContents();

        for (int i = 0; i < contents.length; i++) {
            ItemStack item = contents[i];
            if (item == null || item.getType().isAir()) continue;

            CustomStack custom = CustomStack.byItemStack(item);
            if (custom != null && custom.getNamespacedID().equalsIgnoreCase(namespacedId)) {
                int itemAmount = item.getAmount();

                if (removed + itemAmount <= amountToRemove) {
                    removed += itemAmount;
                    contents[i] = null;
                } else {
                    int needToRemove = amountToRemove - removed;
                    item.setAmount(itemAmount - needToRemove);
                    removed += needToRemove;
                    break;
                }
            }

            if (removed >= amountToRemove) break;
        }

        player.getInventory().setContents(contents); // 인벤토리 반영
        return removed;
    }
    @EventHandler
    public void listener(InventoryClickEvent ev) {
        if (!(ev.getWhoClicked() instanceof Player)) return;
        Player player = (Player) ev.getWhoClicked();
        if (ev.getView().getTitle() == "§f\uEBBB\uEAAA") {
            if (ev.getSlot() == 10 || ev.getSlot() == 11 || ev.getSlot() == 19 ||ev.getSlot() == 20) {
                if (!hasCustomItem(player, "sushi_items:sushi")) {
                    Sushi.sendErrorMessage(player, "현재 오픈할 수 있는 김초밥이 없습니다.");
                    player.closeInventory();
                    return;
                };
                clearCustomItem(player, "sushi_items:sushi", 1);
                sendOpenGui(player, 1,1);
            }
            if (ev.getSlot() == 13 || ev.getSlot() == 14 || ev.getSlot() == 22 || ev.getSlot() == 23) {
                sendStoreGui(player, 1);
            }
            if (ev.getSlot() == 40 || ev.getSlot() == 41 || ev.getSlot() == 31 || ev.getSlot() == 32) {
                ItemStack itemStack = player.getInventory().getItemInMainHand();
                CustomStack customStack = CustomStack.byItemStack(itemStack);
                if (CustomStack.byItemStack(itemStack) == null) {
                    Sushi.sendErrorMessage(player, "해당 아이템은 강화할 수 없는 아이템 입니다.");
                    player.closeInventory();
                    return;
                }
                if (!SushiWeaponSkill.hasSushiData(itemStack) && !SushiWeaponSkill.wasabiPowers.containsKey(customStack.getNamespacedID() + "1")) {
                    Sushi.sendErrorMessage(player, "해당 아이템은 강화할 수 없는 아이템 입니다.");
                    player.closeInventory();
                    return;
                }
                sendUpgradeGui(player, itemStack);
            }
            ev.setCancelled(true);
        };
        if (ev.getClickedInventory().getHolder() instanceof SushiStoreGuiHolder) {
            ev.setCancelled(true);
            SushiStoreGuiHolder holder = (SushiStoreGuiHolder) ev.getClickedInventory().getHolder();
            int page = holder.page;
            List<SushiStoreItem> Items = sushiStoreItems.values().stream().toList();
            if (ev.getSlot() == 45) {
                if (holder.page == 1) {
                    Sushi.sendErrorMessage(player, "더이상 이전 페이지로 가실 수 없습니다.");
                } else {
                    sendStoreGui(player, holder.page-1);
                }
            }
            if (ev.getSlot() == 49) {
                sendMainGui(player);
            }
            if (ev.getSlot() == 53) {
                if (holder.page >= holder.maxPage) {
                    Sushi.sendErrorMessage(player, "더이상 다음 페이지로 가실 수 없습니다.");
                } else {
                    sendStoreGui(player, holder.page+1);
                }
            }
            for (SushiStoreItem item: Items) {
                if ((item.index - (page-1)*35 >= 0) && (item.index - (page-1)*35 < 36)) {
                    int index = item.index-(page-1)*35;
                    index = index+9;
                    if (index == ev.getSlot()) {
                        ItemStack itemStack = ev.getCurrentItem();
                        SushiStoreItem storeItem = sushiStoreItems.get(itemStack.getItemMeta().getDisplayName());
                        if (Sushi.getWasabiGauge(player) < storeItem.wasabi_gauge_price) {
                            Sushi.sendErrorMessage(player, "와사비 게이지가 부족합니다.");
                            player.closeInventory();
                        } else {
                            Sushi.removeWasabiGauge(player, storeItem.wasabi_gauge_price);
                            Sushi.sendMessage(player, "성공적으로 해당 아이템을 구매 했습니다.");
                            player.getInventory().addItem(storeItem.itemStack.clone());
                            sendStoreGui(player, holder.page);
                        }
                    }
                }
            }
        }
        if (ev.getClickedInventory().getHolder() instanceof SushiOpenGuiHolder) {
            SushiOpenGuiHolder holder = (SushiOpenGuiHolder) ev.getClickedInventory().getHolder();
            if (ev.getSlot() == 49) {
                if (holder.guiSushiAmount == 9) {
                    player.closeInventory();
                    Sushi.sendMessage(player, "최종 김초밥 갯수 : "+holder.guiSushiAmount+"개");
                    openSushi(player, holder.guiSushiAmount);
                    ev.setCancelled(true);
                    return;
                }
                if (holder.guiChance != 5) {
                    int amount = holder.guiSushiAmount;
                    int upgradeSushiAmount = upgradeSushiAmount(amount);
                    if (amount != upgradeSushiAmount) {
                        sendOpenGui(player, 1, holder.guiSushiAmount+1);
                    } else {
                        int value = holder.guiSushiAmount;
                        sendOpenGui(player, holder.guiChance+1, value);
                    }
                } else if (holder.guiChance == 5) {
                    player.closeInventory();
                    Sushi.sendMessage(player, "최종 김초밥 갯수 : "+holder.guiSushiAmount+"개");
                    openSushi(player, holder.guiSushiAmount);
                }
            }
            ev.setCancelled(true);
        }
        if (ev.getClickedInventory().getHolder() instanceof SushiUpgradeGuiHolder) {
            ev.setCancelled(true);
            if (ev.getSlot() == 51) {
                sendMainGui(player);
                return;
            }
            SushiUpgradeGuiHolder holder = (SushiUpgradeGuiHolder) ev.getClickedInventory().getHolder();
            if (ev.getSlot() != 33) return;

            ItemStack itemStack = holder.itemStack;

            CustomStack customStack = CustomStack.byItemStack(itemStack);
            String type = customStack.getNamespacedID();

            if (!SushiWeaponSkill.hasSushiData(itemStack)) {
                SushiWeaponSkill.WasabiPower wasabiPower = SushiWeaponSkill.wasabiPowers.get(type + "1");

                if (wasabiPower == null) {
                    Sushi.sendErrorMessage(player, "다음 업그레이드 정보를 찾을 수 없습니다");
                    return;
                }
                if (Sushi.getWasabiGauge(player) < wasabiPower.upgradePrice) {
                    Sushi.sendMessage(player, "아이템을 업그레이드 할 와사비 게이지가 부족합니다!");
                    return;
                }

                Sushi.removeWasabiGauge(player, wasabiPower.upgradePrice);
                SushiWeaponSkill.saveWasabiPowerData(itemStack, wasabiPower);
                Sushi.sendMessage(player, wasabiPower.upgradePrice + "게이지를 사용해 해당 아이템을 1단계로 업그레이드 했습니다!");
                sendUpgradeGui(player, itemStack);
                return;
            }

            SushiWeaponSkill.WasabiPower currentPower = SushiWeaponSkill.loadSushiData(itemStack);

            if (currentPower.upgrade >= 3) {
                player.closeInventory();
                Sushi.sendErrorMessage(player, "이미 아이템이 최대 업그레이드 단계입니다!");
                return;
            }

            SushiWeaponSkill.WasabiPower nextPower = SushiWeaponSkill.wasabiPowers.get(type + (currentPower.upgrade + 1));

            if (Sushi.getWasabiGauge(player) < nextPower.upgradePrice) {
                Sushi.sendMessage(player, "아이템을 업그레이드 할 와사비 게이지가 부족합니다!");
                return;
            }

            Sushi.removeWasabiGauge(player, nextPower.upgradePrice);
            SushiWeaponSkill.saveWasabiPowerData(itemStack, nextPower);
            player.getInventory().setItemInMainHand(itemStack);
            Sushi.sendMessage(player, nextPower.upgradePrice + "게이지를 사용해 해당 아이템을 " + nextPower.upgrade + "단계로 업그레이드 했습니다!");
            sendUpgradeGui(player, itemStack);
        }
    }
    public void openSushi(Player player, int sushiAmount) {
        Sushi.addWasabiGauge(player, (long) sushiAmount);
        if (sushiAmount > 0 && sushiAmount < 4) {
            for (int i = 1; i <= sushiAmount; i++) {
                Collection<SushiOpenReward> allRewards = SushiItemSkill.sushiOpenReward.values();
                List<SushiOpenReward> rareOnes = allRewards.stream().filter(r -> r.rare == 1).toList();
                Random rand = new Random();
                SushiOpenReward selected = rareOnes.get(rand.nextInt(rareOnes.size()));
                selected.itemStack.setAmount(selected.amount);
                player.getInventory().addItem(selected.itemStack);
                Sushi.sendMessage(player, "해당 아이템을 획득 했습니다! "+selected.name);
            }
        } else if (sushiAmount > 3 && sushiAmount < 7) {
            Collection<SushiOpenReward> allRewards = SushiItemSkill.sushiOpenReward.values();
            List<SushiOpenReward> rareOnes = allRewards.stream().filter(r -> r.rare == 2).collect(Collectors.toList());
            Random rand = new Random();
            SushiOpenReward selected = rareOnes.get(rand.nextInt(rareOnes.size()));
            selected.itemStack.setAmount(selected.amount);
            player.getInventory().addItem(selected.itemStack);
            Sushi.sendMessage(player, "해당 아이템을 획득 했습니다! "+selected.name);
            for (int i = 1; i <= sushiAmount-1; i++) {
                allRewards = SushiItemSkill.sushiOpenReward.values();
                rareOnes = allRewards.stream().filter(r -> r.rare == 1).collect(Collectors.toList());
                rand = new Random();
                selected = rareOnes.get(rand.nextInt(rareOnes.size()));
                selected.itemStack.setAmount(selected.amount);
                player.getInventory().addItem(selected.itemStack);
                Sushi.sendMessage(player, "해당 아이템을 획득 했습니다! "+selected.name);
            }
        } else if (sushiAmount > 6 && sushiAmount < 10) {
            Collection<SushiOpenReward> allRewards = SushiItemSkill.sushiOpenReward.values();
            List<SushiOpenReward> rareOnes = allRewards.stream().filter(r -> r.rare == 3).collect(Collectors.toList());
            Random rand = new Random();
            SushiOpenReward selected = rareOnes.get(rand.nextInt(rareOnes.size()));
            selected.itemStack.setAmount(selected.amount);
            player.getInventory().addItem(selected.itemStack);
            Sushi.sendMessage(player, "해당 아이템을 획득 했습니다! "+selected.name);
            for (int i = 1; i <= sushiAmount-1; i++) {
                allRewards = SushiItemSkill.sushiOpenReward.values();
                rareOnes = allRewards.stream().filter(r -> r.rare == 1).collect(Collectors.toList());
                rand = new Random();
                selected = rareOnes.get(rand.nextInt(rareOnes.size()));
                selected.itemStack.setAmount(selected.amount);
                player.getInventory().addItem(selected.itemStack);
                Sushi.sendMessage(player, "해당 아이템을 획득 했습니다! "+selected.name);
            }
        }
    }
    public int upgradeSushiAmount(int sushiAmount) {
        if (sushiAmount == 1) {
            if (ProbabilityUtil.isSuccess(0.40)){
                sushiAmount++;
                return sushiAmount;
            };
        }
        if (sushiAmount == 2) {
            if (ProbabilityUtil.isSuccess(0.35)){
                sushiAmount++;
                return sushiAmount;
            };
        }if (sushiAmount == 3) {
            if (ProbabilityUtil.isSuccess(0.18)){
                sushiAmount++;
                return sushiAmount;
            };
        }if (sushiAmount == 4) {
            if (ProbabilityUtil.isSuccess(0.12)){
                sushiAmount++;
                return sushiAmount;
            };
        }if (sushiAmount == 5) {
            if (ProbabilityUtil.isSuccess(0.08)){
                sushiAmount++;
                return sushiAmount;
            };
        }
        if (sushiAmount == 6) {
            if (ProbabilityUtil.isSuccess(0.15)){
                sushiAmount++;
                return sushiAmount;
            };
        }
        if (sushiAmount == 7) {
            if (ProbabilityUtil.isSuccess(0.13)){
                sushiAmount++;
                return sushiAmount;
            };
        }
        if (sushiAmount == 8) {
            if (ProbabilityUtil.isSuccess(0.12)){
                sushiAmount++;
                return sushiAmount;
            };
        }
        return sushiAmount;
    }
    public static void sendMainGui(Player player) {
        Inventory gui = Bukkit.createInventory(null, 54, "§f\uEBBB\uEAAA");
        ItemStack item = ItemsAdder.getCustomItem("sushi_items:none");
        ItemStack itemstack = item.clone();
        ItemMeta meta = itemstack.getItemMeta();
        meta.setDisplayName("§8[ §2김§a초§f밥 §e먹기 §8]§r");
        meta.setLore(Arrays.asList("§7김초밥을 열어서 여러가지 보상들을 얻을 수 있습니다."));
        itemstack.setItemMeta(meta);
        gui.setItem(10, itemstack);
        gui.setItem(11, itemstack);
        gui.setItem(19, itemstack);
        gui.setItem(20, itemstack);

        itemstack = ItemsAdder.getCustomItem("sushi_items:none");
        meta = itemstack.getItemMeta();
        meta.setDisplayName("§8[ §2김§a초§f밥 §e도감 §8]§r");
        meta.setLore(Arrays.asList("§7김초밥에서 얻을 수 있는 아이템 도감을 엽니다."));
        itemstack.setItemMeta(meta);
        gui.setItem(28, itemstack);
        gui.setItem(29, itemstack);
        gui.setItem(37, itemstack);
        gui.setItem(38, itemstack);

        itemstack = ItemsAdder.getCustomItem("sushi_items:none");
        meta = itemstack.getItemMeta();
        meta.setDisplayName("§8[ §2김§a초§f밥 §e가계 §8]§r");
        meta.setLore(Arrays.asList("§7김초밥 와사비 게이지로 김초밥 관련 아이템들을 삽니다."));
        itemstack.setItemMeta(meta);
        gui.setItem(13, itemstack);
        gui.setItem(14, itemstack);
        gui.setItem(22, itemstack);
        gui.setItem(23, itemstack);

        itemstack = ItemsAdder.getCustomItem("sushi_items:none");
        meta = itemstack.getItemMeta();
        meta.setDisplayName("§8[ §2김§a초§f밥 §e업그레이드 §8]§r");
        meta.setLore(Arrays.asList("§7김초밥 업그레이드 관련 매뉴를 엽니다."));
        itemstack.setItemMeta(meta);
        gui.setItem(31, itemstack);
        gui.setItem(32, itemstack);
        gui.setItem(40, itemstack);
        gui.setItem(41, itemstack);

        player.openInventory(gui);
    };
    public static void sendUpgradeGui(Player player, ItemStack itemStack) {
        Inventory gui = Bukkit.createInventory(new SushiUpgradeGuiHolder("sushi_upgrade_gui", itemStack), 54, "§f\uEBBB\uEAC9");
        gui.setItem(29, SushiItemSkill.upgradingItem(itemStack.clone()));
        gui.setItem(15, playerInfoButton2(player));
        gui.setItem(33, SushiItemSkill.upgradeButton(itemStack.clone()));
        gui.setItem(51, backButton2());
        player.openInventory(gui);
    }
    public static ItemStack backButton2() {
        ItemStack backButton = ItemsAdder.getCustomItem("sushi_items:sushi");
        ItemMeta meta = backButton.getItemMeta();
        meta.setDisplayName("§8[ §2뒤§a로§f가기 §8]§r");
        meta.setLore(Arrays.asList("§a이전 메뉴로 돌아갑니다.", "§8김초밥 매인 매뉴로 돌아가세요."));
        backButton.setItemMeta(meta);
        return backButton;
    } ;
    public static ItemStack playerInfoButton2(Player player) {
        ItemStack item =ItemsAdder.getCustomItem("sushi_items:sushi");
        ItemMeta meta = (ItemMeta) item.getItemMeta();
        meta.setDisplayName("§8[ §2"+player.getName()+"§a님의 §f정보 §8]§r");
        meta.setLore(Arrays.asList("§a현재 §2와사비 게이지 : " + Sushi.getWasabiGauge(player)));
        item.setItemMeta(meta);
        return item;
    };

    public static ItemStack upgradingItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        List<String> array;
        if (meta.hasLore()) {
            array = meta.getLore();
        } else {
            array = new ArrayList<>();
        }
        if (!SushiWeaponSkill.hasSushiData(itemStack)) {
            meta.setDisplayName("§8[ §2업그§a레이§f드 §f0단계 §8]§r");
            array.add("§a무기를 업그레이드 하세요!");
            meta.setLore(array);
            itemStack.setItemMeta(meta);
            return itemStack;
        }
        SushiWeaponSkill.WasabiPower wasabiPower = SushiWeaponSkill.loadSushiData(itemStack);
        if (wasabiPower.upgrade == 1) {
            meta.setDisplayName("§8[ §2업그§a레이§f드 §f1단계 §8]§r");
            array.add("§a무기를 2단계로 업그레이드 하세요!");
        } else if (wasabiPower.upgrade == 2) {
            meta.setDisplayName("§8[ §2업그§a레이§f드 §f2단계 §8]§r");
            array.add("§a무기를 3단계로 업그레이드 하세요!");
        } else if (wasabiPower.upgrade == 3) {
            meta.setDisplayName("§8[ §2업그§a레이§f드 §f3단계 §8]§r");
            array.add("§a더 이상 무기를 업그레이드 하실 수 없습니다!");
        }
        meta.setLore(array);
        itemStack.setItemMeta(meta);
        return itemStack;
    }
    public static ItemStack upgradeButton(ItemStack itemStack) {
        ItemStack upgradeButton = ItemsAdder.getCustomItem("sushi_items:sushi");
        ItemMeta meta = upgradeButton.getItemMeta();
        meta.setDisplayName("§8[ §2업그§a레이§f드 §8]§r");
        meta.setLore(Arrays.asList("§a아이템을 업그레이드 합니다.","", "§8더욱 강한 능력을 부여하세요."));
        upgradeButton.setItemMeta(meta);
        return upgradeButton;
    }
    public void sendOpenGui(Player player, int chance, int sushiAmount) {
        Inventory gui = Bukkit.createInventory(new SushiOpenGuiHolder("sushi_open_gui", chance, sushiAmount), 54, "§f\uEBBB\uEAAB");
        player.openInventory(gui);
        int slot1 = 21;
        int slot2 = 22;
        int slot3 = 23;
        int slot4 = 30;
        int slot5 = 31;
        int slot6 = 32;
        int slot7 = 39;
        int slot8 = 40;
        int slot9 = 41;
        ItemStack itemstack = ItemsAdder.getCustomItem("sushi_items:sushi");
        ItemMeta meta = itemstack.getItemMeta();
        meta.setDisplayName("§8[ §2김§a초§f밥 §8]§r");
        meta.setLore(Arrays.asList("§a어떤 보상이 당신을 기다릴까요?"));
        itemstack.setItemMeta(meta);
        if (sushiAmount == 1) {
            gui.setItem(slot5, itemstack);
        } else if (sushiAmount == 2) {
            gui.setItem(slot4, itemstack);
            gui.setItem(slot6, itemstack);
        } else if (sushiAmount == 3) {
            gui.setItem(slot4, itemstack);
            gui.setItem(slot5, itemstack);
            gui.setItem(slot6, itemstack);
        } else if (sushiAmount == 4) {
            gui.setItem(slot2, itemstack);
            gui.setItem(slot4, itemstack);
            gui.setItem(slot5, itemstack);
            gui.setItem(slot6, itemstack);
        } else if (sushiAmount == 5) {
            gui.setItem(slot1, itemstack);
            gui.setItem(slot3, itemstack);
            gui.setItem(slot4, itemstack);
            gui.setItem(slot5, itemstack);
            gui.setItem(slot6, itemstack);
        } else if (sushiAmount == 6) {
            gui.setItem(slot1, itemstack);
            gui.setItem(slot2, itemstack);
            gui.setItem(slot3, itemstack);
            gui.setItem(slot4, itemstack);
            gui.setItem(slot5, itemstack);
            gui.setItem(slot6, itemstack);
        } else if (sushiAmount == 7) {
            gui.setItem(slot1, itemstack);
            gui.setItem(slot2, itemstack);
            gui.setItem(slot3, itemstack);
            gui.setItem(slot4, itemstack);
            gui.setItem(slot5, itemstack);
            gui.setItem(slot6, itemstack);
            gui.setItem(slot8, itemstack);
        } else if (sushiAmount == 8) {
            gui.setItem(slot1, itemstack);
            gui.setItem(slot3, itemstack);
            gui.setItem(slot4, itemstack);
            gui.setItem(slot5, itemstack);
            gui.setItem(slot6, itemstack);
            gui.setItem(slot7, itemstack);
            gui.setItem(slot8, itemstack);
            gui.setItem(slot9, itemstack);
        }else if (sushiAmount == 9) {
            gui.setItem(slot1, itemstack);
            gui.setItem(slot2, itemstack);
            gui.setItem(slot3, itemstack);
            gui.setItem(slot4, itemstack);
            gui.setItem(slot5, itemstack);
            gui.setItem(slot6, itemstack);
            gui.setItem(slot7, itemstack);
            gui.setItem(slot8, itemstack);
            gui.setItem(slot9, itemstack);
        }
        ItemStack sushiSword = ItemsAdder.getCustomItem("sushi_weapons:sushi_sword");
        if (chance == 5) {
            meta = sushiSword.getItemMeta();
            meta.setDisplayName("§8[ §2김§a초§f밥 검 §8]§r");
            meta.setLore(Arrays.asList("§a최대 업그레이드 횟수에 도달 했습니다. "+"클릭해서 김초밥 보상을 얻으세요!"));
            sushiSword.setItemMeta(meta);
        } else {
            meta = sushiSword.getItemMeta();
            meta.setDisplayName("§8[ §2김§a초§f밥 검 §8]§r");
            meta.setLore(Arrays.asList("§a김초밥을 써세요! "+ chance+"/4번"));
            sushiSword.setItemMeta(meta);
        }

        if (sushiAmount == 9) {
            meta = sushiSword.getItemMeta();
            meta.setDisplayName("§8[ §2김§a초§f밥 검 §8]§r");
            meta.setLore(Arrays.asList("§a김초밥이 9개입니다! 행운이 일어났네요!"));
            sushiSword.setItemMeta(meta);
        }
        gui.setItem(49, sushiSword);
        player.openInventory(gui);

    };
    public static ItemStack nextPageButton(int page, int maxPage) {
        ItemStack nextPageButton = ItemsAdder.getCustomItem("sushi_items:sushi");
        ItemMeta meta = nextPageButton.getItemMeta();
        meta.setDisplayName("§8[ §2▶ 다§a음§f 페이지 §8]§r");
        meta.setLore(Arrays.asList("§7다음 상점 페이지로 이동합니다.", "§8클릭하여 다음 페이지를 확인하세요.", "§a현재 페이지 "+page+"/"+maxPage));
        nextPageButton.setItemMeta(meta);
        return nextPageButton;
    };
    public static ItemStack previousPageButton(int page, int maxPage) {
        ItemStack previousPageButton = ItemsAdder.getCustomItem("sushi_items:sushi");
        ItemMeta meta = previousPageButton.getItemMeta();
        meta.setDisplayName("§8[ §2◀ 이§a전§f 페이지 §8]§r");
        meta.setLore(Arrays.asList("§7이전 상점 페이지로 돌아갑니다", "§8클릭하여 돌아가세요.", "§a현재 페이지 "+page+"/"+maxPage));
        previousPageButton.setItemMeta(meta);
        return previousPageButton;
    } ;
    public static ItemStack backButton() {
        ItemStack backButton = ItemsAdder.getCustomItem("sushi_items:sushi");
        ItemMeta meta = backButton.getItemMeta();
        meta.setDisplayName("§8[ §2뒤§a로§f가기 §8]§r");
        meta.setLore(Arrays.asList("§7이전 메뉴로 돌아갑니다.", "§8김초밥 매인 매뉴로 돌아가세요."));
        backButton.setItemMeta(meta);
        return backButton;
    } ;
    public static ItemStack playerInfoButton(Player player) {
        ItemStack item =ItemsAdder.getCustomItem("sushi_items:none");
        ItemMeta meta = (ItemMeta) item.getItemMeta();
        meta.setDisplayName("§8[ §2"+player.getName()+"§a님의 §f정보 §8]§r");
        meta.setLore(Arrays.asList("§a현재 §2와사비 게이지 : " + Sushi.getWasabiGauge(player)));
        item.setItemMeta(meta);
        return item;
    };
    public static void sendStoreGui(Player player, int page) {
        List<SushiStoreItem> shopItems = sushiStoreItems.values().stream().toList();
        int maxPage;
        int maxIndex = 0;
        for (SushiStoreItem shopItem : shopItems) {
            if (shopItem.index > maxIndex) maxIndex = shopItem.index;
        }
        maxPage = (int) Math.ceil((double) maxIndex / 35);
        Inventory gui = Bukkit.createInventory(new SushiStoreGuiHolder("§f\uEBBB\uEAAC", page, maxPage), 54, "§f\uEBBB\uEAAC");
        for (SushiStoreItem item: shopItems) {
                if ((item.index - (page-1)*35 >= 0) && (item.index - (page-1)*35 < 36)) {
                    int index = item.index-(page-1)*35;
                    index = index+9;
                    ItemStack itemStack = item.itemStack.clone();
                    ItemMeta itemmeta = itemStack.getItemMeta();
                    itemmeta.setDisplayName(item.name);
                    List<String> array = new ArrayList<>(Arrays.asList(item.description));
                    array.add("§a와사지 게이지: §2"+item.wasabi_gauge_price);
                    itemmeta.setLore(array);
                    itemStack.setItemMeta(itemmeta);
                    gui.setItem(index, itemStack);
                }
        }
        gui.setItem(45, previousPageButton(page, maxPage));
        gui.setItem(49, backButton());
        gui.setItem(53, nextPageButton(page, maxPage));
        gui.setItem(6, playerInfoButton(player));
        player.openInventory(gui);
    };
    public static class SushiOpenGuiHolder implements InventoryHolder {
        private final String guiId;
        private int guiChance;
        private int guiSushiAmount;
        public SushiOpenGuiHolder(String guiId, int guiChance, int guiSushiAmount) {
            this.guiId = guiId;
            this.guiChance = guiChance;
            this.guiSushiAmount = guiSushiAmount;
        }

        public String getGuiId() {
            return guiId;
        }

        @NotNull
        @Override
        public Inventory getInventory() {
            return null;
        }
    }
    public static class SushiStoreGuiHolder implements InventoryHolder {
        private final String guiId;
        private int page;
        public int maxPage;
        public SushiStoreGuiHolder(String guiId, int page, int maxPage) {
            this.guiId = guiId;
            this.page = page;
            this.maxPage = maxPage;
        }

        public String getGuiId() {
            return guiId;
        }

        @NotNull
        @Override
        public Inventory getInventory() {
            return null;
        }
    }
    public static class SushiUpgradeGuiHolder implements InventoryHolder {
        private final String guiId;
        private ItemStack itemStack;
        public SushiUpgradeGuiHolder(String guiId, ItemStack itemStack) {
            this.guiId = guiId;
            this.itemStack = itemStack;
        }

        public String getGuiId() {
            return guiId;
        }

        @NotNull
        @Override
        public Inventory getInventory() {
            return null;
        }
    }
    public static class ProbabilityUtil {
        private static final Random random = new Random();
        public static boolean isSuccess(double chance) {
            if (chance <= 0) return false;
            if (chance >= 1) return true;
            return random.nextDouble() < chance;
        }

    }
}

