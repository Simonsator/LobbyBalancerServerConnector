package de.simonsator.partyandfriends.serverconnector.playerbalancer;

import com.jaimemartz.playerbalancer.helper.PlayerLocker;
import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.api.friends.ServerConnector;
import de.simonsator.partyandfriends.friends.subcommands.Jump;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * @author Simonsator
 * @version 1.0.0 26.06.17
 */
public class PBServerConnector extends PAFExtension implements ServerConnector {
	public void onEnable() {
		Jump.setServerConnector(this);
	}

	public void connect(ProxiedPlayer pPlayer, ServerInfo pServerInfo) {
		PlayerLocker.lock(pPlayer);
		pPlayer.connect(pServerInfo);
		PlayerLocker.unlock(pPlayer);
	}

}
