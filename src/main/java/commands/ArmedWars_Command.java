package commands;

import commands.subs.Arena_sub;
import commands.subs.Help_sub;
import commands.subs.List_sub;
import commands.types.ISubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;


public class ArmedWars_Command implements CommandExecutor {

    private static HashMap<String, ISubCommand> subCommands = new HashMap<>();

    static {
        subCommands.put("arena", new Arena_sub());
        subCommands.put("help", new Help_sub());
        subCommands.put("list", new List_sub());

    }






    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0){
            return true;
        }
        ISubCommand subCommand = subCommands.get(strings[0].toLowerCase());
        subCommand.onCommand(commandSender, command, s, strings);

        return true;
    }
}
