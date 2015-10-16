package com.github.tckz916.lobbyescape;

import com.github.tckz916.lobbyescape.listener.EntityListener;
import com.github.tckz916.lobbyescape.listener.PlayerListener;
import com.github.tckz916.lobbyescape.manager.list.Double_Jump;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by tckz916 on 2015/10/17.
 */
public class LobbyEscape extends JavaPlugin {

    private static LobbyEscape instance = null;

    private PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable() {
        super.onEnable();

        instance = this;

        registerlistener(new PlayerListener());
        registerlistener(new EntityListener());

        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void registerlistener(Listener listener) {
        pluginManager.registerEvents(listener, this);
    }

    public static LobbyEscape getInstance() {
        return instance;
    }
}
