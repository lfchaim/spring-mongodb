package br.com.whs.springmongodb.repository;

import br.com.whs.springmongodb.entity.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, String> {

}
