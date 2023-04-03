package com.mtlt.repository;

import com.mtlt.entity.usersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface usersRepository extends MongoRepository<usersEntity, String> {
}
