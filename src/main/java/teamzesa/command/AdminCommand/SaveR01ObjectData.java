package teamzesa.command.AdminCommand;

import org.apache.commons.lang3.ObjectUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import teamzesa.DataBase.IOHandler.RObjectIOHandler;
import teamzesa.DataBase.UserKillStatusHandler.KillStatusController;
import teamzesa.DataBase.entity.RObject.User;
import teamzesa.DataBase.userHandler.UserController;
import teamzesa.command.register.CommandRegisterSection;
import teamzesa.util.Enum.ColorList;
import teamzesa.util.Enum.CommandType;
import teamzesa.util.Enum.DataFile;

import java.util.Optional;


public class SaveR01ObjectData extends CommandRegisterSection {
    private Player senderPlayer;
    private boolean consoleSend = false;

    public SaveR01ObjectData() {
        super(CommandType.SAVE_R01_OBJECT_DATA);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, String label, String[] args) {
        User senderUser = null;
        try {
            senderUser = new UserController().readUser(sender.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Optional.ofNullable(senderUser).ifPresentOrElse(
                existUser -> this.senderPlayer = Bukkit.getPlayer(existUser.uuid()),
                () -> this.consoleSend = true
        );

        if (senderUser != null && !this.senderPlayer.isOp()) {
            playerSendMsgComponentExchanger(this.senderPlayer, "해당 명령어는 플레이어가 사용할 수 없습니다.", ColorList.RED);
            return false;
        }

        new RObjectIOHandler().exportData(
                DataFile.USER_DATA, new UserController().getAllUserTable(), getClass().getName()
        );

        new RObjectIOHandler().exportData(
                DataFile.KILL_STATUS, new KillStatusController().getAllUserTable(), getClass().getName()
        );
/*
        if (args == null || args[0].isEmpty()) {
            this.rObjectIOHandler.exportData(DataFile.USER_DATA, getClass().getName(),
                    new UserController().getAllUserTable());

            this.rObjectIOHandler.exportData(DataFile.KILL_STATUS, getClass().getName(),
                    new KillStatusController().getAllUserTable());
        }

        else if (args[0].equalsIgnoreCase("data"))
            this.rObjectIOHandler.exportData(DataFile.USER_DATA, getClass().getName(),
                    new UserController().getAllUserTable());

        else if (args[0].equalsIgnoreCase("killStatus"))
            this.rObjectIOHandler.exportData(DataFile.KILL_STATUS, getClass().getName(),
                    new KillStatusController().getAllUserTable());
*/
        sendComment("Success to exporting UserData");
        return true;
    }

    private void sendComment(String comment) {
        if (consoleSend && ObjectUtils.isEmpty(this.senderPlayer))
            Bukkit.getLogger().info("[R01] " + comment);
        else playerSendMsgComponentExchanger(this.senderPlayer, comment, ColorList.YELLOW);
    }
}
