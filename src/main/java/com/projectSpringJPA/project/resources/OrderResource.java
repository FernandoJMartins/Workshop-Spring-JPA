package com.projectSpringJPA.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectSpringJPA.project.entities.Order;
import com.projectSpringJPA.project.entities.User;
import com.projectSpringJPA.project.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService os;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = os.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = os.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
