package hh.swd20.MyRecipes.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	//attributes
	private Long categoryId;
	private String categoryName;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	//private List<Category> categories;
	
	//Constructors
	public Category() {}
	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
	//getters
	public Long getCategoryId() {
		return categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	
	//setters
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	//to-string
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	

}
