package teamzesa.event.Restricted;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import teamzesa.event.EventRegister.EventRegister;
import teamzesa.util.Enum.ColorMap;
import teamzesa.util.Interface.StringComponentExchanger;

import java.util.Arrays;
import java.util.Objects;

public class RestrictedDispenser extends StringComponentExchanger implements EventRegister {

    private Player player;
    private ItemStack itemStack;
    private Inventory clickerInventory;
    private Inventory currentOpeningContainerInventory;
    private final InventoryClickEvent event;

    public RestrictedDispenser(InventoryClickEvent event) {
        this.event = event;
        init();
        execute();
    }

    @Override
    public void init() {
        this.player = (Player) this.event.getWhoClicked();
        this.itemStack = this.event.getCurrentItem();
        this.clickerInventory = this.event.getClickedInventory();
        this.currentOpeningContainerInventory = this.event.getInventory();
    }

    @Override
    public void execute() {
        if (this.clickerInventory == null)
            return;

        if (this.currentOpeningContainerInventory.getType() != InventoryType.DISPENSER)
            return;

        if (this.clickerInventory.getType() != InventoryType.PLAYER)
            return;

        if (this.player.isOp())
            return;

        if (this.itemStack.getType() != Material.ARMOR_STAND)
            return;

        this.event.setCancelled(true);
        playerSendMsgComponentExchanger(player, "아머스탠드는 디스펜서에 넣을 수 없습니다.", ColorMap.RED);
    }
}
