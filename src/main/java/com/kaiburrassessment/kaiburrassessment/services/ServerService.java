package com.kaiburrassessment.kaiburrassessment.services;

import java.util.List;

import com.kaiburrassessment.kaiburrassessment.entities.Server;

public interface ServerService {

	public List<Server> getAllServers();
	public List<Server> getServerByIsRunning(Boolean isRunning);
	public Server getServerById(String serverId);
	public Server addServer(Server server);
	public Server updateServer(Server server);
	public String deleteServerById(String serverId);


}
