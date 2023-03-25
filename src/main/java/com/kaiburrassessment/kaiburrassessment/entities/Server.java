package com.kaiburrassessment.kaiburrassessment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "servers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
	@Id
	private String serverId;
	private String name;
	private String language;
	private String framework;
	private Boolean isRunning;
	
}
