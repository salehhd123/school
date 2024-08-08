package com.example.school.Service;


import com.example.school.API.ApiException;
import com.example.school.Dto.CourseDto;
import com.example.school.Dto.ExtraDataDto;
import com.example.school.Dto.PagDto;
import com.example.school.Dto.TeacherDto;
import com.example.school.Mapper.TeacherMapper;
import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Model.TeacherDetails;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TeacherService {


    private  final TeacherRepository teacherRepository;
    private final CourseService courseService;
    private final TeacherMapper teacherMapper;


    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }



//    public List<TeacherDto> getAll(){
//        return teacherMapper.teacherToTeacherDto(teacherRepository.findAll());
//    }

//    public List<TeacherDto> getit(){
//        List<Teacher> teachers = teacherRepository.findAll();
//        List<TeacherDto> teacherDtos = new ArrayList<>();
//
//        for (Teacher teacher : teachers) {
//            TeacherDto teacherDto = new TeacherDto(teacher.getFirstName(),teacher.getLastName(),teacher.getTeacherDetails().getAge(),teacher.getTeacherDetails().getPhoneNumber(),teacher.getCourses());
//            teacherDtos.add(teacherDto);
//        }
//        return teacherDtos;
//    }

    public void add(Teacher teacher){
        teacherRepository.save(teacher);
    }


    public Teacher addCoursesAndDetailsWithTeacher(TeacherDto teacherDto){
        Teacher teacher = new Teacher(null,teacherDto.getFirstName(),teacherDto.getLastName(),null,null);
        TeacherDetails teacherDetails = new TeacherDetails(null,teacherDto.getAge(),teacherDto.getPhoneNumber(),teacher);
        teacher.setTeacherDetails(teacherDetails);
        List<Course> courses = new ArrayList<>();
        for (CourseDto courseDto : teacherDto.getCourses()){
            Course course = new Course(null,courseDto.getName(),teacher);
           courses.add(course);
        }
        teacher.setCourses(courses);
        teacherRepository.save(teacher);
        return teacher;
    }


    public void changeTheCourseFromTeacher(Integer id ,List<CourseDto> courses){
        Optional<Teacher> teacher1= teacherRepository.findById(id);
        if (teacher1.isPresent()){
            Teacher teacher = teacher1.get();
            List<Course> newCourseList = new ArrayList<>();
            for (CourseDto c : courses) {
                Course course = new Course(null, c.getName(), teacher);
                newCourseList.add(course);
            }
            teacher.getCourses().clear();
            teacher.getCourses().addAll(newCourseList);
            teacherRepository.save(teacher);
        }else {
            throw new ApiException ("not found!");
        }
    }



    public void remove(Integer id){
        Optional<Teacher> teacher= teacherRepository.findById(id);
//        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher.isPresent()){
            Teacher teacher1 = teacher.get();
            teacherRepository.delete(teacher1);
        }else {
            throw new ApiException ("not found!");
        }
    }


    public List<TeacherDto> find(){
      List<Teacher> teachers = teacherRepository.findAll();
        return teacherMapper.teachersToTeacherDtos(teachers);
    }

    @Transactional
    public void addTeacherAndCourseWithCheck(TeacherDto teacherDto){
        Teacher teacher = new Teacher(null,teacherDto.getFirstName(),teacherDto.getLastName(),null,null);
        TeacherDetails teacherDetails = new TeacherDetails(null,teacherDto.getAge(),teacherDto.getPhoneNumber(),teacher);
        teacher.setTeacherDetails(teacherDetails);
        teacherRepository.save(teacher);
        for (CourseDto courseDto : teacherDto.getCourses()){
            Course course = new Course(null,courseDto.getName(),teacher);
            courseService.Add(course);
        }
    }
    public List<ExtraDataDto> getAllByExtra(){
        return teacherRepository.getAllExtraData();
    }

    public List<PagDto> getPag(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Teacher> page1 = teacherRepository.findAll(pageable);
        List<Teacher> teachers = page1.getContent();
        return teacherMapper.teachersToPag(teachers);
    }



//    public TeacherDatails remove(Integer id){
//        TeacherDatails teacher = teacherDeatailsRep.findTeacherDatailsById(id);
//
//        return teacher;
//    }


}
