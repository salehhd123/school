package com.example.school.Service;


import com.example.school.API.ApiException;
import com.example.school.Model.Course;
import com.example.school.Model.Teacher;
import com.example.school.Repository.CourseRepository;
import com.example.school.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {


private final CourseRepository courseRepository;
private final TeacherRepository teacherRepository;


    public List<Course> getAll(){
        return courseRepository.findAll();
    }


    public void Add(Course course){
        Course course1 = courseRepository.findCourseByName(course.getName());
        if (course1==null){
            courseRepository.save(course);
        }
        else throw new ApiException("the name already use " + course.getName());
    }


    public void addToTeacher(Integer teacherId,Integer courseId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);
        course.setTeacher(teacher);
        courseRepository.save(course);
    }


    public void delete (Integer id){
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()){
            Course course1 = course.get();
            courseRepository.delete(course1);
        }else {
            throw new ApiException("not found!");
        }

    }

    public Course findByName (String name){
        Course course = courseRepository.findCourseByName(name);
        return course;
    }




}
