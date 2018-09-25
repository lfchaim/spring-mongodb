package br.com.whs.springmongodb.service;

import br.com.whs.springmongodb.entity.User;
import br.com.whs.springmongodb.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listUser() {
        return userRepository.findAll();
    }

    public Page<User> listPaging(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return userRepository.findAll(pages);
    }

    public List<User> findByName(String name) {
        return userRepository.findByNameLikeIgnoreCase(name);
    }

    public User saveUser(User userAdd) {
        return userRepository.save(userAdd);
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }

    public User getById(String id) {
        return userRepository.findOne(id);
    }

}
