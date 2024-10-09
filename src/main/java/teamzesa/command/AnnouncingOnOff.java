package teamzesa.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import teamzesa.DataBase.entity.RObject.User;
import teamzesa.DataBase.UserHandler.UserBuilder;
import teamzesa.DataBase.UserHandler.UserController;
import teamzesa.command.register.CommandRegisterSection;
import teamzesa.util.Enum.ColorList;
import teamzesa.util.Enum.CommandType;

public class AnnouncingOnOff extends CommandRegisterSection {

    public AnnouncingOnOff() {
        super(CommandType.ANNOUNCING);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        User targetUser = new UserController().readUser(((Player) commandSender).getUniqueId());

        String comment = targetUser.announcingSkip() ? "비활성화" : "활성화";
        playerSendMsgComponentExchanger(commandSender, "공지 " + comment + " 완료", ColorList.YELLOW);

        new UserBuilder(targetUser)
                .isAnnouncingSkip(!targetUser.announcingSkip())
                .buildAndUpdate();
        return true;
    }
}