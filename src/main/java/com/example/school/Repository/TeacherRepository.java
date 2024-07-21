package com.example.school.Repository;

import com.example.school.Dto.ExtraDataDto;
import com.example.school.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

Teacher findTeacherById(Integer id);

     @Query("select new com.example.school.Dto.ExtraDataDto(t.firstName, t.teacherDetails.phoneNumber,c.name)" +
             " from Teacher t join t.courses c")
List<ExtraDataDto> getAllExtraData();


}
