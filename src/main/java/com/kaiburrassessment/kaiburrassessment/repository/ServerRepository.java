package com.kaiburrassessment.kaiburrassessment.repository;

import java.util.*;
import com.kaiburrassessment.kaiburrassessment.entities.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServerRepository extends MongoRepository<Server, String> {

    public List<Server> findByIsRunning(Boolean isRunning);
    public Server findByName(String name);
}
