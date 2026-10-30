package com.tenant.tenantDemo.Service;

import com.tenant.tenantDemo.Exception.RecordNotFoundException;
import com.tenant.tenantDemo.Entity.User;
import com.tenant.tenantDemo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(String userName) throws RecordNotFoundException {
        List<User> userList = userRepo.findByUsername(userName);
        if (userList.size() == 1) {
            User user = userList.getFirst();
            userRepo.deleteById(user.getUserid());
        } else {
            throw new RecordNotFoundException("No Record Found Plz verify");
        }
    }

    public void updateEmailId(User user) throws RecordNotFoundException {
        Optional<User> id = userRepo.findById(user.getUserid());
        if (id.isPresent() && user.getEmailid() != null) {
            User oldUser = userRepo.findById(user.getUserid()).get();
            oldUser.setEmailid(user.getEmailid());
            userRepo.save(oldUser);

        } else {
            throw new RecordNotFoundException("No Record Found Plz verify");
        }
    }

    public void updatePassword(User user) throws RecordNotFoundException {
        Optional<User> id = userRepo.findById(user.getUserid());
        if (id.isPresent()) {
            User oldUser = userRepo.findById(user.getUserid()).get();
            oldUser.setPassword(user.getPassword());
            userRepo.save(oldUser);

        } else {
            throw new RecordNotFoundException("No Record Found Plz verify");
        }
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public  User findUserId(int id) throws RecordNotFoundException {
       Optional<User> optionalUser =userRepo.findById(id);
       User user=null;
       if(optionalUser.isPresent()) {
           user= optionalUser.get();
       } else {
           throw new RecordNotFoundException("No Record Found Plz verify");
       }
       return user;
    }


}
