package teamzesa.event.Enhance.Interface;

import org.bukkit.Material;

public interface Armour {
    static <E extends Armour> E findByMaterial(Material material) throws Exception {
        return null;
    }

    Material getMaterial();
}
