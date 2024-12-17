package com.inventory.grocery.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.grocery.domain.Grocery;
import com.inventory.grocery.exception.ResourceNotFoundException;
import com.inventory.grocery.repository.GroceryRepository;

@Service
public class GroceryService {
	
	@Autowired
	GroceryRepository groceryrepository;
	
	
	public List<Grocery> getByCategory(String category){
		return groceryrepository.findByCategory(category);
	}
	
	
	public List<Grocery> getallGroceries(){
		return groceryrepository.findAll();
	
}
	public Grocery getGroceryById(Integer id){
		return groceryrepository.findById(id).orElseThrow(() -> new RuntimeException("grocery not found"));
	}
	public Grocery getByName(String name) {
		return groceryrepository.findByName(name);
	}
	public Grocery creategrocery(Grocery addgrocery) {
		return groceryrepository.save(addgrocery);
	}
	public Grocery updateGrocery(Integer id,Grocery updateGrocery) {
		Grocery existingGrocery= groceryrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Grocery not found with ID: " + id));

		existingGrocery.setName(updateGrocery.getName());
		existingGrocery.setTotalstock(updateGrocery.getTotalstock());
		existingGrocery.setActualPrice(updateGrocery.getActualPrice());
		return groceryrepository.save(existingGrocery);
		
		
	}
	public void deleteById(Integer id) {
		 groceryrepository.deleteById(id);
	}
	public List<Grocery> addBulk(List<Grocery> grocery){
		return groceryrepository.saveAll(grocery);
		
	}
	public Map<String,Long> groupByCategory(){
		List<Grocery> group= groceryrepository.findAll();
		return group.stream()
				.collect(Collectors.groupingBy(Grocery :: getCategory,Collectors.counting()));
		
	}
	
}
