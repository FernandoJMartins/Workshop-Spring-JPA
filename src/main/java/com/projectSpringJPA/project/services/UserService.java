package com.projectSpringJPA.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectSpringJPA.project.entities.User;
import com.projectSpringJPA.project.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository us;
	
	public List<User> findAll() {
		return us.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = us.findById(id);
		return obj.get();
	}
}
