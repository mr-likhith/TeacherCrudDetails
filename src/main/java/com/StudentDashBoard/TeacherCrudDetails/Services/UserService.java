package com.StudentDashBoard.TeacherCrudDetails.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentDashBoard.TeacherCrudDetails.Repository.UserRepository;
import com.StudentDashBoard.TeacherCrudDetails.model.UserModel;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserModel registerUser(String login, String password, String username) {
        if (login == null || password == null) {
            return null;
        } else {
            UserModel userModel = new UserModel();
            userModel.setLogin(login);
            userModel.setPassword(password);
            userModel.setUsername(username);
            return userRepository.save(userModel);
        }
    }
    
    public UserModel authenticate(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
