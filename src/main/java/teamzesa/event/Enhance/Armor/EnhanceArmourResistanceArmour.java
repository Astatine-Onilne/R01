package teamzesa.event.Enhance.Armor;

import org.apache.commons.lang3.ObjectUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import teamzesa.event.Enhance.Interface.EnhanceUtil;
import teamzesa.event.EventRegister.EventRegister;

public class EnhanceArmourResistanceArmour implements EventRegister {

    private Entity targetEntity;
    private final EntityDamageByEntityEvent event;

    public EnhanceArmourResistanceArmour(EntityDamageByEntityEvent event) {
        this.event = event;
        init();
        execute();
    }

    @Override
    public void init() {
        this.targetEntity = this.event.getEntity();
    }

    @Override
    public void execute() {
        if (ObjectUtils.notEqual(this.targetEntity.getType(), EntityType.PLAYER))
            return;

        Player target = (Player) this.targetEntity;
        ItemStack[] armour = new ItemStack[4];
        armour[0] = target.getInventory().getHelmet();
        armour[1] = target.getInventory().getChestplate();
        armour[2] = target.getInventory().getLeggings();
        armour[3] = target.getInventory().getBoots();

        double totalDmg = EnhanceUtil.calculatingTotalResistancePercentage(armour, this.event.getFinalDamage());
        this.event.setDamage(totalDmg);
    }
}
