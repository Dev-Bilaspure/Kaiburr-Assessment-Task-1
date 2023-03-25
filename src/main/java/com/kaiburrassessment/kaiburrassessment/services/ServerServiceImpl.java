package com.kaiburrassessment.kaiburrassessment.services;

import java.util.*;

import com.kaiburrassessment.kaiburrassessment.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kaiburrassessment.kaiburrassessment.entities.Server;


@Service
public class ServerServiceImpl implements ServerService {

	@Autowired
	private ServerRepository serverRepository;

	/**
	 * Retrieve a list of all server objects currently stored in the system.
	 *
	 * @return a list of all Server objects in the system
	 */
	@Override
	public ResponseEntity<List<Server>> getAllServers()  {
		try {
			List<Server> servers = serverRepository.findAll();
			if (!servers.isEmpty()) {
				return ResponseEntity.ok(servers); // Return the list of Server objects with a success status code
			} else {
				return ResponseEntity.notFound().build(); // Return a failure status code if no servers are found
			}
		} catch (Exception e) {
			// handling exception
			System.out.println("An error occurred while retrieving the list of servers: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return an error status code
		}
	}



	/**
	 * Retrieve a list of all server objects currently stored in the system with the specified "isRunning" status.
	 *
	 * @param isRunning a Boolean value indicating the desired "isRunning" status of the servers to retrieve
	 * @return a list of Server objects with the specified "isRunning" status
	 */
	@Override
	public ResponseEntity<List<Server>> getServerByIsRunning(Boolean isRunning) {
		try {
			List<Server> servers = serverRepository.findByIsRunning(isRunning);
			if (!servers.isEmpty()) {
				return ResponseEntity.ok(servers); // Return the list of Server objects with a success status code
			} else {
				return ResponseEntity.notFound().build(); // Return a failure status code if no servers with the specified "isRunning" status are found
			}
		} catch (Exception e) {
			// handling exception
			System.out.println("An error occurred while retrieving the list of servers: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return an error status code
		}
	}


	/**
	 * Retrieve a server object from the system with the specified server ID.
	 *
	 * @param serverId a String value indicating the ID of the server to retrieve
	 * @return the Server object with the specified ID, or null if no such server exists
	 */
	@Override
	public ResponseEntity<Server> getServerById(String serverId) {
		try {
			Server server = serverRepository.findById(serverId).orElse(null);
			if (server != null) {
				return ResponseEntity.ok(server); // Return the Server object with a success status code
			} else {
				return ResponseEntity.notFound().build(); // Return a failure status code if no server with the specified ID is found
			}
		} catch (Exception e) {
			// handling exception
			System.out.println("An error occurred while retrieving the server: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return an error status code
		}
	}


	/**
	 * Add a new server object to the system.
	 *
	 * @param server a Server object containing the data for the server to add
	 * @return the newly added Server object
	 */
	@Override
	public ResponseEntity<Server> addServer(Server server) {
		try {
			Server addedServer = serverRepository.save(server); // Add the Server object to the repository and return it
			return ResponseEntity.ok(addedServer);
		} catch (Exception e) {
			// handling exception
			System.out.println("An error occurred while adding the server: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}



	/**
	 * Update an existing server in the system with the given server object.

	 * @param server the updated Server object to be saved
	 * @return the updated Server object that has been saved
	 */
	@Override
	public ResponseEntity<Server> updateServer(Server server) {
		Server existingServer = null; // Declare a variable to store the existing server object
		try {
			// Try to find the existing server object in the repository by its ID
			existingServer = serverRepository.findById(server.getServerId()).orElse(null);
			if (existingServer != null) { // If the existing server is found, update its properties
				existingServer.setName(server.getName());
				existingServer.setIsRunning(server.getIsRunning());
				existingServer.setFramework(server.getFramework());
				existingServer.setLanguage(server.getLanguage());
				serverRepository.save(existingServer); // Save the updated server object to the repository
				return ResponseEntity.ok(existingServer);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch(Exception e) { // If an error occurs, catch it and log a message
			// handle exception
			System.out.println("An error occurred while updating the server: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}



	/**
	 * Delete the server object with the specified ID from the system.
	 *
	 * @param serverId a String value indicating the ID of the server to delete
	 * @return a String message indicating the status of the operation
	 */
	@Override
	public ResponseEntity<String> deleteServerById(String serverId) {
		try {
			Optional<Server> existingServer = serverRepository.findById(serverId); // Retrieve the Server object with the specified ID from the repository
			if (existingServer.isPresent()) {
				serverRepository.delete(existingServer.get()); // Delete the Server object from the repository
				return ResponseEntity.ok("Server with ID " + serverId + " has been deleted"); // Return a success message
			} else {
				return ResponseEntity.notFound().build(); // Return a failure message
			}
		} catch (Exception e) {
			// handling exception
			System.out.println("An error occurred while deleting the server: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Retrieves a server with the given name from the data source.
	 *
	 * @param name The name of the server to retrieve.
	 * @return The server with the given name, or null if no such server exists.
	 */
	@Override
	public ResponseEntity<Server> getServerByName(String name) {
		try {
			// Retrieve the Server object with the specified name from the repository
			Optional<Server> server = Optional.ofNullable(serverRepository.findByName(name));
			if (server.isPresent()) {
				return ResponseEntity.ok(server.get());
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			// Handle any exceptions
			System.err.println("An error occurred while retrieving the server: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
