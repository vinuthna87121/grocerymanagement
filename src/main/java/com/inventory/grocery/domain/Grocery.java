package com.inventory.grocery.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Grocery {
	@Override
	public int hashCode() {
		return Objects.hash(actualPrice, category, discountedPrice, id, name, totalstock);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grocery other = (Grocery) obj;
		return Float.floatToIntBits(actualPrice) == Float.floatToIntBits(other.actualPrice)
				&& Objects.equals(category, other.category)
				&& Float.floatToIntBits(discountedPrice) == Float.floatToIntBits(other.discountedPrice)
				&& id == other.id && Objects.equals(name, other.name) && totalstock == other.totalstock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public float getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(float discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public int getTotalstock() {
		return totalstock;
	}
	public void setTotalstock(int totalstock) {
		this.totalstock = totalstock;
	}
	public Grocery() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grocery(int id, String name, String category, float actualPrice, float discountedPrice, int totalstock) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.actualPrice = actualPrice;
		this.discountedPrice = discountedPrice;
		this.totalstock = totalstock;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String category;
	@Column(nullable=false)
	private float actualPrice;
	@Column(nullable=false)
	private float discountedPrice;
	@Column(nullable=false)
	private int totalstock;

	
	
	
	

}
