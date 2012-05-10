package me.psychoma.customidentify;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.getspout.commons.ChatColor;
import org.getspout.spoutapi.block.SpoutBlock;

public class BlockListener
    implements Listener
{

    public BlockListener(CustomIDentify plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onIDBlockClick(PlayerInteractEvent event)
    {
    	if (event.getClickedBlock() != null)
    	{
        if(((SpoutBlock) event.getClickedBlock()).getCustomBlock() == CustomIDentify.IDBlock && event.getPlayer().getItemInHand() != null && event.getPlayer().isSneaking() && event.getAction() == Action.RIGHT_CLICK_BLOCK && (CustomIDentify.permission.has(event.getPlayer(), "customidentify") || event.getPlayer().isOp()))
        {
            event.setCancelled(true);
            event.getPlayer().sendMessage((new StringBuilder()).append((new StringBuilder()).append(ChatColor.GREEN).append("ID ").toString()).append(event.getPlayer().getItemInHand().getTypeId()).append(" : ").append(event.getPlayer().getItemInHand().getDurability()).toString());
            return;
        } else
        {
           return;
        }
    	}
    }

    public CustomIDentify plugin;
    public SpoutBlock block;
}
