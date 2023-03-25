package com.kaiburrassessment.kaiburrassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kaiburrassessment.kaiburrassessment.entities.Server;
import com.kaiburrassessment.kaiburrassessment.services.ServerService;



@RestController
@RequestMapping("/api/servers")
public class ServerController {
	
	@Autowired
	private ServerService serverService;

	@GetMapping("/check")
	public String checkingServer() {
		return "Server is running...";
	}
	@GetMapping
	public ResponseEntity<List<Server>> getAllServers() {
		return serverService.getAllServers();
	}

	@GetMapping("/{serverId}")
	public ResponseEntity<Server> getServerById(@PathVariable String serverId) {
		return serverService.getServerById((serverId));
	}

	@GetMapping("/status/{isRunning}")
	public ResponseEntity<List<Server>> getServersByRunningStatus(@PathVariable String isRunning) {
		return serverService.getServerByIsRunning(Boolean.parseBoolean((isRunning)));
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Server> getServersByName(@PathVariable String name) {
		return serverService.getServerByName(name);
	}

	@PostMapping
	public ResponseEntity<Server> addServer(@RequestBody Server server) {
		return serverService.addServer(server);
	}

	@PutMapping
	public ResponseEntity<Server> updateServer(@RequestBody Server server) {
		return serverService.updateServer(server);
	}

	@DeleteMapping("/{serverId}")
	public ResponseEntity<String> deleteServer(@PathVariable String serverId) {
		return serverService.deleteServerById(serverId);
	}

}
