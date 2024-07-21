package com.example.school.Repository;


import com.example.school.Model.Course;
import com.example.school.Model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential,Integer> {


    @Query("select t from UserCredential t where t.email=?1 ")
    UserCredential findByEmail(String email);
    @Query("select t from UserCredential t where t.email=?1 and t.password=?2")
    UserCredential login(String email,String password);
}
