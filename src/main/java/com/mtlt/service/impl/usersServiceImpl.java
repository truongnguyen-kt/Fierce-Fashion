package com.mtlt.service.impl;

import com.mtlt.entity.usersEntity;
import com.mtlt.repository.usersRepository;
import com.mtlt.service.usersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class usersServiceImpl implements usersService {
    @Autowired
    usersRepository userRepo;

    @Override
    public String addNewUser(usersEntity user) {
        try {
            log.info(user.toString());
            usersEntity Euser = userRepo.findByEmail(user.getEmail());
            usersEntity Uuser = userRepo.findByUsername(user.getUsername());
            if (Uuser != null) {
                System.out.println(userRepo.findById(user.getUsername()));
                return "This username is already used! Try another name!";
            }
            if (Euser != null) {
                return "This email is already used! Try another email!";
            }
            userRepo.save(user);
            return "Create successfully!!";
        } catch (Exception ex) {
            log.info(ex.getMessage());
            return "Sorry. There are some error. Try again later!!";
        }
    }

    @Override
    public usersEntity checkLogin(String id, String password) {
        try {
            usersEntity Euser = userRepo.findByEmailAndPassword(id, password);
            usersEntity Uuser = userRepo.findByUsernameAndPassword(id, password);
            if (Euser != null) {
                return Euser;
            }
            if (Uuser != null) {
                return Uuser;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }
}
