package com.flightapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.exception.UserAlreadyExistsException;
import com.flightapp.model.User;
import com.flightapp.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) {
		if(userRepository.existsByEmailId(user.getEmailId())) {
			throw new UserAlreadyExistsException(user.getEmailId());
		}
		
		userRepository.save(user);
	}
}

