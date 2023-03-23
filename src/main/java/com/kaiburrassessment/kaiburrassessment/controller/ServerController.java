package com.kaiburrassessment.kaiburrassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kaiburrassessment.kaiburrassessment.entities.Server;
import com.kaiburrassessment.kaiburrassessment.services.ServerService;



@RestController
public class ServerController {
	
	@Autowired
	private ServerService serverService;
	
	@GetMapping("/home")
	public String home() {
		return("This is home page");
	}
	
	
	//get the list of servers
	@GetMapping("/servers")
	public List<Server> getServers() {
		return(this.serverService.getServers());
	}
	
	@GetMapping("/servers/{serverId}")
	public Server getServer(@PathVariable String serverId) {
		return(this.serverService.getServer(serverId));
	}
	
	@PostMapping("/server")
	public Server addServer(@RequestBody Server server) {
		return(this.serverService.addServer(server));
	}
	
}
