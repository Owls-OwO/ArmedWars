package commands.subs;

import arena.Arena;
import commands.types.ISubCommand;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import utils.messages.ColotTextMessage;

import java.util.ArrayList;
import java.util.List;

public class Arena_sub implements ISubCommand {
    private static List<Arena> arenas_list = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] strings) {
        ColotTextMessage.logConsole("&2Arena_sub");

        if (!(commandSender instanceof Player)) {
            ColotTextMessage.logConsole("&4Only players!");
            return true;
        }
        Player player = (Player) commandSender;
        if (strings.length < 2) {
            ColotTextMessage.sendMessage(player, "/aw arena {create/setspawn}");
            return true;

        }



        // strings[0] 'arena'
        // strings[1] 'create'
        // /aw arena "Create" {arena name} {max players}

        if (strings[1].toLowerCase().equals("create")) {
            if (strings.length != 4) {
                ColotTextMessage.sendMessage(player, "/aw arena create {arena name} {max players}");
                return true;
            }
            int max_player = Integer.parseInt(strings[3]);
            if (max_player % 2 == 0) {
                arenas_list.add(new Arena(strings[2], max_player));

                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BELL, 1.0F, 1.0F);
                
                ColotTextMessage.sendMessage(player, "The arena&6 \"" + strings[2] + "\"&r has been &2created!");
            }
            else {
                ColotTextMessage.sendMessage(player, "An even number of players!");
            }
        }
        // /aw arena {arena name} "setspawn"
        else if (strings[1].toLowerCase().equals("setspawn")){
            if (strings.length != 3 && strings.length != 4) {
                ColotTextMessage.sendMessage(player, "/aw arena setspawn {arena name} {team1/team2}");
                return true;
            }

            if (!find_game_name(strings[2])){
                ColotTextMessage.sendMessage(player, "Arena not found!");
                return true;
            }


            if (strings[3].toLowerCase().equals("team1") ){
                for(Arena arena : arenas_list){
                    if (arena.get_name().toLowerCase().equals(strings[2].toLowerCase())){
                        arena.set_spawnpoint_team1(player.getLocation());
                        ColotTextMessage.sendMessage(player, "Spawn point team1!");
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BELL, 1.0F, 1.0F);
                        return true;
                    }
                }


            } else if (strings[3].toLowerCase().equals("team2") ) {
                for(Arena arena : arenas_list){
                    if (arena.get_name().toLowerCase().equals(strings[2].toLowerCase())){
                        arena.set_spawnpoint_team1(player.getLocation());
                        ColotTextMessage.sendMessage(player, "Spawn point team2!");
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BELL, 1.0F, 1.0F);
                        return true;
                    }
                }


            }
        }


        return true;
    }


    public static List<Arena> get_arenas_list(){
        return arenas_list;
    }

    public static boolean find_game_name(String name){
        for (Arena arena : arenas_list){
            if (arena.get_name().toLowerCase().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }
}
