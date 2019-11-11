package hh.swd20.MyRecipes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.MyRecipes.domain.Category;
import hh.swd20.MyRecipes.domain.CategoryRepository;
import hh.swd20.MyRecipes.domain.Recipe;
import hh.swd20.MyRecipes.domain.RecipeRepository;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeRepository RecRepo;
	
	@Autowired
	private CategoryRepository CatRepo;
	
	//Login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	//RESTful service to return categories
	@RequestMapping(value = "/categories", method =  RequestMethod.GET)
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) CatRepo.findAll();
	}
	//RESTful service that returns one category by id
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {
		return CatRepo.findById(categoryId);
	}
	
	//LISTing categories
	@RequestMapping(value = "/home", method = RequestMethod.GET) 
	public String categorylist(Model model) {
		List<Category> categories = (List<Category>) CatRepo.findAll();
		model.addAttribute("categories", categories);
		return "home";
	}
	
	/*LISTing recipes
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public String recipelist(@PathVariable("id") Long categoryId, Model model) {
		List<Recipe> recipes = (List<Recipe>) CatRepo.findAllById(categoryId));
		model.addAttribute("recipes", recipes);
		return "category";
	}
	*/
	
	//LIST all recipes
	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public String recipelist(Model model) {
		List<Recipe> recipes = (List<Recipe>) RecRepo.findAll();
		model.addAttribute("recipes", recipes);
		return "recipes";
	}
	
	//ADD NEW recipe form
	@RequestMapping(value = "/newrecipe", method = RequestMethod.GET)
	public String newRecipeForm(Model model) {
		model.addAttribute("recipe", new Recipe()); //empty recipe object
		model.addAttribute("categories", CatRepo.findAll());
		return "newrecipe";
	}
	
	//ADD NEW category
	@RequestMapping(value = "/newcategory", method = RequestMethod.GET)
	public String newCategoryForm(Model model) {
		model.addAttribute("category", new Category()); //empty category object
		return "newcategory";
	}
	
	//SAVE recipe
	@RequestMapping(value = "newrecipe", method = RequestMethod.POST)
	public String saveRecipe(@ModelAttribute Recipe recipe) {
		//saving one recipe data into the repository
		RecRepo.save(recipe);
		return "redirect:/home";
	}
	
	//EDIT recipe
	@RequestMapping(value = "/editrecipe/{id}", method = RequestMethod.GET)
	public String editRecipe(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recipe", RecRepo.findById(id));
		model.addAttribute("categories", CatRepo.findAll());
		return "editrecipe";
	}
	
	//DELETE recipe
	@RequestMapping(value = "/deleterecipe/{id}", method = RequestMethod.GET)
	public String deleteRecipe(@PathVariable("id") Long id) {
		RecRepo.deleteById(id);
		return "redirect:../home";
	}
	
	//SHOW one recipe
	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
	public String showRecipe(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recipe", RecRepo.findById(id));
		model.addAttribute("categories", CatRepo.findAll());
		return "";
	}
	

	
	
	
}
