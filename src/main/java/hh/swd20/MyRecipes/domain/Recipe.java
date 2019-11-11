package hh.swd20.MyRecipes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Recipe {
	
	//attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String foodTitle;
	private String time;
	private String ingredients;
	private String guide;
	//private ?? picture;
	//kategoria tähän myöhemmin
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryId")
	private Category category;
	
	//Construtors
	public Recipe(String foodTitle, String time, String ingredients, String guide, Category category) {
		super();
		this.foodTitle = foodTitle;
		this.time = time;
		this.ingredients = ingredients;
		this.guide = guide;
		this.category = category;
	}
	public Recipe() { }
	
	//getters
	public Long getId() {
		return id;
	}
	public String getFoodTitle() {
		return foodTitle;
	}
	public String getTime() {
		return time;
	}
	public String getIngredients() {
		return ingredients;
	}
	public String getGuide() {
		return guide;
	}
	public Category getCategory() {
		return category;
	}
	
	//setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setFoodTitle(String foodTitle) {
		this.foodTitle = foodTitle;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	//to-string
	@Override
	public String toString() {
		if(this.category != null)
			return "Recipe [id=" + id + ", foodTitle=" + foodTitle + ", time=" + time + ", ingredients=" + ingredients
				+ ", guide=" + guide + " category =" + this.getCategory() + "]";
		else
			return "Recipe [id=" + id + ", foodTitle=" + foodTitle + ", time=" + time + ", ingredients=" + ingredients
					+ ", guide=" + guide + "]";
	}
	

}
