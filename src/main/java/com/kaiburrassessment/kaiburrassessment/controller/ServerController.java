package com.kaiburrassessment.kaiburrassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Server> getAllServers() {
		return serverService.getAllServers();
	}

	@GetMapping("/{serverId}")
	public Server getServerById(@PathVariable String serverId) {
		return serverService.getServerById((serverId));
	}

	@GetMapping("/running")
	public List<Server> getServersByRunningStatus(@RequestParam("isRunning") boolean isRunning) {
		return serverService.getServerByIsRunning(isRunning);
	}

	@PostMapping
	public Server addServer(@RequestBody Server server) {
		return serverService.addServer(server);
	}

	@PutMapping
	public Server updateServer(@RequestBody Server server) {
		return serverService.updateServer(server);
	}

	@DeleteMapping("/{serverId}")
	public String deleteServer(@PathVariable String serverId) {
		return serverService.deleteServerById(serverId);
	}

}
