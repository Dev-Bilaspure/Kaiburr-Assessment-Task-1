package com.kaiburrassessment.kaiburrassessment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

@Document(collection = "server")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
	@Id
	private String serverId;
//	@Indexed(unique = true)
	private String name;
	private String language;
	private String framework;
	private Boolean isRunning;
	
}
