package commands.subs;

import commands.types.ISubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import utils.ColotTextMessage;

public class Help_sub implements ISubCommand {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {

        ColotTextMessage.logConsole("&3Help_sub");

        return false;
    }
}
