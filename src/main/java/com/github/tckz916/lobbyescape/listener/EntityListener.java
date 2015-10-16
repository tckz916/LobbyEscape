package com.github.tckz916.lobbyescape.listener;

import com.github.tckz916.lobbyescape.manager.list.Double_Jump;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by tckz916 on 2015/10/17.
 */
public class EntityListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player) entity;
        if (Double_Jump.contains(player) && event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            event.setCancelled(true);
            Double_Jump.remove(player);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity (EntityDamageByEntityEvent event){
        Entity damager = event.getDamager();
        Entity entity = event.getEntity();
        if (!(entity instanceof Player || damager instanceof Player)) {
            return;
        }
        Player shooter = (Player) damager;
        Player target = (Player) entity;


    }
}
