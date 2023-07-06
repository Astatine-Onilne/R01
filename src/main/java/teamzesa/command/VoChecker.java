package teamzesa.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import teamzesa.userValue.User;
import teamzesa.userValue.UserHandler;

public class VoChecker implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        User user = UserHandler
                .getUserHandler()
                .getUser(Bukkit.getPlayer(args[0]));

        Bukkit.getLogger().info(user.toString());
        return true;
    }
}
