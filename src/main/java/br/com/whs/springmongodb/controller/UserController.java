package br.com.whs.springmongodb.controller;

import br.com.whs.springmongodb.entity.User;
import br.com.whs.springmongodb.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listr() {
        return this.userService.listUser();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable String id) {
        return this.userService.getById(id);
    }

    @RequestMapping(value = "/user/{page}/{count}", method = RequestMethod.GET)
    public Page<User> listPaging(@PathVariable int page, @PathVariable int count) {
        return this.userService.listPaging(count, page);
    }

    @RequestMapping(value = "/user/{name}/name", method = RequestMethod.GET)
    public List<User> listPaging(@PathVariable String name) {
        return this.userService.findByName(name);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User editar(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable String id) {
        this.userService.deleteUser(id);
    }

}
