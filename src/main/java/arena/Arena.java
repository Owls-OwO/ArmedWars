package arena;

import org.bukkit.Location;
import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.List;

public class Arena {

    private String arena_name;
    private boolean game_status = false;
    private int game_max_player;
    private int count_player_team1 = 0;
    private int count_player_team2 = 0;
    private List<Player> team1 = new ArrayList<>();
    private List<Player> team2 = new ArrayList<>();
    private Location spawnpoint_team1;
    private Location spawnpoint_team2;
    private int game_time;


    public Arena(String name, int max_player){
        arena_name = name;
        game_max_player = max_player;
    }



    public void set_spawnpoint_team1(Location location){
        spawnpoint_team1 = location;
    }
    public void set_spawnpoint_team2(Location location){
        spawnpoint_team2 = location;
    }

    public void add_player(Player player){



    }

    public void remove_player(){



    }

    public void disconnected_player(){



    }

    public int get_players_count(){
        return count_player_team1 + count_player_team2;
    }

    public String get_name(){
        return arena_name;
    }
    public boolean get_game_status(){
        return game_status;
    }

    public int getCount_player_team1() {
        return count_player_team1;
    }

    public int getCount_player_team2() {
        return count_player_team2;
    }

    public int getGame_max_player() {
        return game_max_player;
    }
}
