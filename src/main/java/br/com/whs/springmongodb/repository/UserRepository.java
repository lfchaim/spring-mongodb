package br.com.whs.springmongodb.repository;

import br.com.whs.springmongodb.entity.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByNameLikeIgnoreCase(String name);
}
