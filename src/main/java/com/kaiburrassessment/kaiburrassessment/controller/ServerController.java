package com.kaiburrassessment.kaiburrassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kaiburrassessment.kaiburrassessment.entities.Server;
import com.kaiburrassessment.kaiburrassessment.services.ServerService;



@RestController
@RequestMapping("/api/servers")
@CrossOrigin(origins = "http://localhost:3000")
public class ServerController {
	
	@Autowired
	private ServerService serverService;


	// to quick check if the server is up and running or not
	@GetMapping("/check")
	public String checkingServer() {
		return "Server is running...";
	}


	// This endpoint returns a list of all servers in the system.
	@GetMapping
	public ResponseEntity<List<Server>> getAllServers() {
		return serverService.getAllServers();
	}


	// This endpoint returns a single server by its ID.
	@GetMapping("/{serverId}")
	public ResponseEntity<Server> getServerById(@PathVariable String serverId) {
		return serverService.getServerById((serverId));
	}


	// This endpoint returns a single server by its name.
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Server>> getServersByName(@PathVariable String name) {
		return serverService.getServerByName(name);
	}


	// This endpoint adds a new server to the system.
	@PostMapping
	public ResponseEntity<Server> addServer(@RequestBody Server server) {
		return serverService.addServer(server);
	}


	// This endpoint updates an existing server.
	@PutMapping
	public ResponseEntity<Server> updateServer(@RequestBody Server server) {
		return serverService.updateServer(server);
	}


	// This endpoint deletes a server by its ID.
	@DeleteMapping("/{serverId}")
	public ResponseEntity<String> deleteServer(@PathVariable String serverId) {
		return serverService.deleteServerById(serverId);
	}

}
