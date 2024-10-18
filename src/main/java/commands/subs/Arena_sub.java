package commands.subs;

import commands.types.ISubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import utils.ColotTextMessage;

public class Arena_sub implements ISubCommand {


    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {

        ColotTextMessage.logConsole("&3Arena_sub");

        return false;
    }
}
