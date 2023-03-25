package com.kaiburrassessment.kaiburrassessment.services;

import java.util.List;

import com.kaiburrassessment.kaiburrassessment.entities.Server;
import org.springframework.http.ResponseEntity;

public interface ServerService {

	public ResponseEntity<List<Server>> getAllServers();
	public ResponseEntity<Server> getServerById(String serverId);
	public ResponseEntity<Server> addServer(Server server);
	public ResponseEntity<Server> updateServer(Server server);
	public ResponseEntity<String> deleteServerById(String serverId);
	public ResponseEntity<List<Server>> getServerByName(String name);

}
