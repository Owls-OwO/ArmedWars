package utils.messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ColotTextMessage {

    public static String recolorText (String text) {
        return ChatColor.translateAlternateColorCodes('&', text);

    }

    public static void sendMessage (Player player, String message) {
        player.sendMessage(recolorText(message));


    }

    public static void logConsole (String message) {
        Bukkit.getConsoleSender().sendMessage(recolorText(message));
    }


}
