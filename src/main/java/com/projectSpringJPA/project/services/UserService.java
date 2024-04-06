package com.projectSpringJPA.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectSpringJPA.project.entities.User;
import com.projectSpringJPA.project.repositories.UserRepository;
import com.projectSpringJPA.project.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	public List<User> findAll() {
		return ur.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = ur.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return ur.save(user);
	}

	public void delete(Long id) {
		ur.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User entity = ur.getReferenceById(id);
		updateData(entity, user);
		return ur.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
}
