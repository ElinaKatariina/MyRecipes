package hh.swd20.MyRecipes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.MyRecipes.domain.User;
import hh.swd20.MyRecipes.domain.UserRepository;
import hh.swd20.MyRecipes.domain.Category;
import hh.swd20.MyRecipes.domain.CategoryRepository;
import hh.swd20.MyRecipes.domain.Recipe;
import hh.swd20.MyRecipes.domain.RecipeRepository;
import jdk.internal.jline.internal.Log;

@SpringBootApplication
public class MyRecipesApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(MyRecipesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MyRecipesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner categoryDemo(RecipeRepository RecRepo, CategoryRepository CatRepo, UserRepository userRepo) {
		return (args) -> {
			log.info("");
			CatRepo.save(new Category("Pasta"));
			CatRepo.save(new Category("Soup"));
			CatRepo.save(new Category("Chicken"));
			CatRepo.save(new Category("Meat"));
			CatRepo.save(new Category("Sides"));
			CatRepo.save(new Category("Dessert"));
			
			RecRepo.save(new Recipe("Kermainen kanapasta", "30min", "Kanasuikaleet, pasta, kerma, tuorejuusto", "Keitä pasta. Paista kana. Lisää kerma, mausteita ja tuorejuusto kanan joukkoon. Yhdistä kana ja pasta.", CatRepo.findByCategoryName("Pasta").get(0)));
					
			//Create users
			User user1 = new User("user", "$2a$10$yNpJp8q9BKsHUpdaFLLXhu2UtIDN1yBe.uHedEixG4QIcftP76fAe", "USER");
			User user2 = new User("admin", "$2a$10$yUEOx8AlF8TIi7ztCft.Hu4x6MKtqAK0zCaYGHlNQn9QChzLHBKbu", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
			
			log.info("fetch all recipes");
			for (Recipe recipe : RecRepo.findAll()) {
				log.info(recipe.toString());
			}
		};
	}
}
