package com.mtlt.repository;

import com.mtlt.entity.usersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface usersRepository extends MongoRepository<usersEntity, String> {
    usersEntity findByEmail(String email);
    usersEntity findByUsername(String username);
    usersEntity findByEmailAndPassword(String email, String password);
    usersEntity findByUsernameAndPassword(String username, String password);
}
