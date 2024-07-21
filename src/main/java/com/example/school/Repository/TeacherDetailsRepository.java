package com.example.school.Repository;

import com.example.school.Model.TeacherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherDetailsRepository extends JpaRepository<TeacherDetails,Integer> {



TeacherDetails findTeacherDetailsById(Integer id);


}
