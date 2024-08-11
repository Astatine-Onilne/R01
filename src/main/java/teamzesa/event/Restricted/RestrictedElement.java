package teamzesa.event.Restricted;

import org.bukkit.Material;

import java.util.HashSet;
import java.util.Set;

public class RestrictedElement {
    public final Set<Material> restrictedItem = new HashSet<>();
    public final Set<String> restrictedCommand = new HashSet<>();

    public RestrictedElement() {
        restrictedItem.add(Material.ARMOR_STAND);

        restrictedCommand.add("/pl");
        restrictedCommand.add("/plugins");
    }
}
