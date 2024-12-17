package com.inventory.grocery.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.grocery.domain.Grocery;

@Repository
public interface GroceryRepository  extends JpaRepository<Grocery,Integer>{
	Grocery findByName(String name);
	List<Grocery> findByCategory(String category);
	
	

}
