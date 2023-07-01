package teamzesa.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import teamzesa.userValue.UserHandler;

public class NameChanger implements CommandExecutor {
    private UserHandler userHandler;

    public NameChanger() {
        userHandler = UserHandler.getUserHandler();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Bukkit.getPlayer(args[0]);

        if (player == null) {
            sender.sendPlainMessage(ChatColor.RED + "플레이어를 찾을 수 없습니다.");
            return true;
        }

        String newNickname = args[1];
        player.sendPlainMessage(ChatColor.YELLOW + player.getName() + "님의 닉네임을 " + newNickname + "로 변경하였습니다.");
        ChatColor listNameColor = null;

        if (args[2].equals("moder"))
            listNameColor = ChatColor.RED;

        if (args[2].equals("user"))
            listNameColor = ChatColor.WHITE;

        String newName = listNameColor + newNickname;

        setPlayerNameTag(player,newName);
        player.setCustomName(newName + " " + ChatColor.WHITE + args[0]);
        player.setPlayerListName(newName + " " + ChatColor.WHITE + args[0]);
        userHandler.updateUser(player.getUniqueId(),newName);
        return true;
    }

    public void setPlayerNameTag(Player player, String nameTag) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getEntryTeam(player.getName());

        if (team == null)
            team = scoreboard.registerNewTeam(player.getName());

        team.setPrefix(nameTag+" ");
        team.addEntry(player.getName());
    }
}