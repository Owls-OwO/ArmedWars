package commands.subs;

import arena.Arena;
import commands.types.ISubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.messages.ColotTextMessage;

public class List_sub implements ISubCommand {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {


        Player player = (Player) commandSender;

        ColotTextMessage.sendMessage(player ,"Arenas list:");
        for (Arena arena : Arena_sub.get_arenas_list()){
            String str = "";
            if (arena.get_game_status()){
                str += "&2";
            } else {
                str += "&4";
            }
            str += arena.get_name() + " ";
            str += "&r[" + arena.get_players_count() + "/" + arena.getGame_max_player() + "]";
            ColotTextMessage.sendMessage(player, str);
        }

        return true;
    }
}
