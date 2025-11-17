package com.flightapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	boolean existsByEmailId(String emailId);
}

