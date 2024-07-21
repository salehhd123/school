package com.example.school.Service;


import com.example.school.API.ApiException;
import com.example.school.API.ApiResponse;
import com.example.school.Model.UserCredential;
import com.example.school.Repository.UserCredentialRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserCredentialService {

private final UserCredentialRepository userCredentialRepository;


public void login(String email,String password){
    UserCredential userCredential1 = userCredentialRepository.findByEmail(email);
  if (userCredential1==null){
      throw new ApiException("the email is wrong");
  }
    UserCredential userCredential2 = userCredentialRepository.login(email, password);
    if (email==null){
        throw new ApiException("the email can not be empty");
    }
    if (password==null){
        throw new ApiException("the password can not be empty");
    }
    if (userCredential2 == null){
        throw new ApiException("the password is wrong ");
    }
    if (userCredential2.isStatus()){
        throw new ApiException("already login");
    }
    userCredential2.setStatus(true);
    userCredentialRepository.save(userCredential2);
}


    public void logout(Integer id){
        Optional<UserCredential> userCredential = userCredentialRepository.findById(id);
        if (userCredential.isEmpty()){
            throw new ApiException("wrong id");
        }
        else {
            UserCredential userCredential1 = userCredential.get();
            if (!userCredential1.isStatus()){
                throw new ApiException("already logout");
            }
            userCredential1.setStatus(false);
            userCredentialRepository.save(userCredential1);
        }
    }


    public void createUser(UserCredential userCredential){
        try {
            userCredentialRepository.save(userCredential);
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("email already used");
        }
    }

}
