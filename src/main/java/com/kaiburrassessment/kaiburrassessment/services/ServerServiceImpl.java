package com.kaiburrassessment.kaiburrassessment.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.kaiburrassessment.kaiburrassessment.entities.Server;


@Service
public class ServerServiceImpl implements ServerService {

	List<Server> lst;
	public ServerServiceImpl() {
		lst = new ArrayList<>();
		lst.add(new Server("vtop-server", "1234", "java", "spring-boot"));
		lst.add(new Server("ipl-server", "1235", "javascript", "node"));
		lst.add(new Server("tg-server", "1254", "python", "django"));
		lst.add(new Server("cdc-server", "1354", "java", "spring-boot"));
	}
	@Override
	public List<Server> getServers() {
		return(lst);
	}
	@Override
	public Server getServer(String serverId) {
		Server s=null;
		for(Server server:lst) {
			if(server.getId().equals(serverId)) {
				s=server;
				break;
			}
		}
		return(s);
	}
	@Override
	public Server addServer(Server server) {
		lst.add(server);
		return(server);
	}

}
