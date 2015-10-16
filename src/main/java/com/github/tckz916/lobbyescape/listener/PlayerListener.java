package com.github.tckz916.lobbyescape.listener;

import com.github.tckz916.lobbyescape.LobbyEscape;
import com.github.tckz916.lobbyescape.manager.list.Double_Jump;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

/**
 * Created by tckz916 on 2015/10/17.
 */
public class PlayerListener implements Listener {

    private LobbyEscape plugin = LobbyEscape.getInstance();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        plugin.reloadConfig();
        Player player = event.getPlayer();
        boolean allowFlight = player.getAllowFlight();
        boolean isOnGround = player.isOnGround();
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR
                || allowFlight || !isOnGround) {
            return;
        }
        player.setAllowFlight(true);
    }


    @EventHandler
    public void onToggleFight(PlayerToggleFlightEvent event) {
        plugin.reloadConfig();
        Player player = event.getPlayer();
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        if (plugin.getConfig().get("double_jump") == null) {
            return;
        }
        double height = plugin.getConfig().getDouble("double_jump.height");
        double lenght = plugin.getConfig().getDouble("double_jump.lenght");

        event.setCancelled(true);
        player.setAllowFlight(false);
        player.setFlying(false);
        player.setVelocity(player.getLocation().getDirection().multiply(lenght).setY(height));
        player.spigot().playEffect(player.getLocation(), Effect.CLOUD, 0, 0, 0.1F, 0.1F, 0.1F, 0.5F, 100, 1);
        player.playSound(player.getLocation(), Sound.FIZZ, 10.0F, 1.0F);
        Double_Jump.add(player);
    }

}
