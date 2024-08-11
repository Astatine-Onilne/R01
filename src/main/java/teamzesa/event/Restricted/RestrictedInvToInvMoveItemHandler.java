package teamzesa.event.Restricted;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import teamzesa.event.EventRegister.EventRegister;

public class RestrictedInvToInvMoveItemHandler implements EventRegister {

    private final InventoryMoveItemEvent event;
    public RestrictedInvToInvMoveItemHandler(InventoryMoveItemEvent event) {
        this.event = event;
        init();
        execute();
    }

    @Override
    public void init() {
    }

    @Override
    public void execute() {
        if (ObjectUtils.notEqual(this.event.getDestination().getType(), InventoryType.DISPENSER))
            return;

        Material moveItemMaterial = this.event.getItem().getType();
        boolean isRestrictedItem = new RestrictedElement().restrictedItem.stream()
                .anyMatch(moveItemMaterial::equals);

        if (BooleanUtils.isFalse(isRestrictedItem))
            return;

        this.event.setCancelled(true);
    }
}
