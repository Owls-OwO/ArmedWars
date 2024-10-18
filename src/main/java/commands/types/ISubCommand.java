package commands.types;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface ISubCommand {

    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings);

}
