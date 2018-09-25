package br.com.whs.springmongodb.service;

import br.com.whs.springmongodb.entity.Profile;
import br.com.whs.springmongodb.repository.ProfileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository perfilRepository;

    public List<Profile> listProfile() {
        return perfilRepository.findAll();
    }

    public Page<Profile> listPaging(int count, int page) {
        Pageable pages = new PageRequest(page, count);
        return perfilRepository.findAll(pages);
    }


    public Profile saveProfile(Profile perfil) {
        return perfilRepository.save(perfil);
    }

    public void deleteProfile(String id) {
        perfilRepository.delete(id);
    }

    public Profile getById(String id) {
        return perfilRepository.findOne(id);
    }

}
