package hh.swd20.MyRecipes.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
