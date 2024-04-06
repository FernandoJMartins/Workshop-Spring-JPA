package com.projectSpringJPA.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projectSpringJPA.project.entities.User;
import com.projectSpringJPA.project.repositories.UserRepository;
import com.projectSpringJPA.project.services.exceptions.DatabaseException;
import com.projectSpringJPA.project.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	    try {
	        if (ur.existsById(id)) {
	            ur.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    }catch (ResourceNotFoundException e){
	        throw new ResourceNotFoundException(id);
	    }
	    catch (DataIntegrityViolationException e) {
	    	throw new DatabaseException(e.getMessage());
	    }
	}
	
	public User update(Long id, User user) {
		try {
			User entity = ur.getReferenceById(id);
			updateData(entity, user);
			return ur.save(entity);
		}
		catch (EntityNotFoundException e) {
	        throw new ResourceNotFoundException(id);
		}
			
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
}
