package com.kaiburrassessment.kaiburrassessment.services;

import java.util.List;

import com.kaiburrassessment.kaiburrassessment.entities.Server;

public interface ServerService {

	public List<Server> getServers();
	
	public Server getServer(String serverId);
	
	public Server addServer(Server server);
}
