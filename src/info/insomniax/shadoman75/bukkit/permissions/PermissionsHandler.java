package info.insomniax.shadoman75.bukkit.permissions;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.permission.Permission;
import info.insomniax.shadoman75.bukkit.MePlugin;

public class PermissionsHandler {
	public MePlugin myPlugin = null;
	
	public PermissionsHandler(MePlugin instance){
		myPlugin = instance;
	}
	private static Permission permission = null;

    public boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = myPlugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
    public boolean has(CommandSender sender, String node){
    	return permission.has(sender, node);

    	
    }
}
