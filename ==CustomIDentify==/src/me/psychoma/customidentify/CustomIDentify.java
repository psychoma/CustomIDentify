package me.psychoma.customidentify;

import java.util.logging.Level;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.material.CustomBlock;

public class CustomIDentify extends JavaPlugin
{
	public static CustomBlock IDBlock;
	public static Permission permission = null;
	
    public CustomIDentify()
    {
    }

    public void onDisable()
    {
        Bukkit.getLogger().log(Level.INFO, "[CustomIDentify] Disabled!");
    }

    public void onEnable()
    {
        IDBlock = new IDBlock(this);
        setupPermissions();
        Bukkit.getLogger().log(Level.INFO, "[CustomIDentify] Enabled!");
        getServer().getPluginManager().registerEvents(new BlockListener(this), this);
    }
    
    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
}
