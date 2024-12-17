package com.inventory.grocery.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.grocery.domain.Grocery;
import com.inventory.grocery.repository.GroceryRepository;
import com.inventory.grocery.service.GroceryService;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
	
	@Autowired
	GroceryService groceryservice;
	@Autowired
	GroceryRepository groceryrepository;

	@GetMapping
	public List<Grocery> getall(){
		return groceryservice.getallGroceries();
		
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Grocery>> findByCategory(@PathVariable  String category){
		List<Grocery> result=groceryservice.getByCategory(category);
		if(result != null) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	@GetMapping ("/id/{id}")
	public ResponseEntity<Grocery> getById(@PathVariable Integer id){
		Grocery g = groceryservice.getGroceryById(id);
	
	 if(g != null) {
		return ResponseEntity.ok(g);
		
	}
	 else {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
	 }
	@PostMapping("/add")
	public Grocery addGrocery(@RequestBody Grocery addgrocery ) {
		return groceryservice.creategrocery(addgrocery);
	}
	@PutMapping("/update/{id}")
	public Grocery updateGrocery(@PathVariable Integer id, @RequestBody Grocery updateGrocery ) {
		return groceryservice.updateGrocery(id, updateGrocery);
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteGrocery(@PathVariable Integer id) {
         groceryservice.deleteById(id);
		
	}
	@PostMapping("/addbulk")
		public List<Grocery> addBulk(@RequestBody List<Grocery> grocery){
		return groceryservice.addBulk(grocery);
			
		}
	@GetMapping("/groupByCategory")
	public Map<String,Long> groupByCategory(){
		return groceryservice.groupByCategory();
	}
	}
	

