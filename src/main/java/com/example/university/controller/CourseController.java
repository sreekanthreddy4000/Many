package com.example.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.university.model.*;
import com.example.university.service.*;

@RestController
public class CourseController {

    @Autowired
    private CourseJpaService courseService;

    @GetMapping("/professors/courses")
    public ArrayList<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/professors/courses/{courseId}")
    public Course getCourseById(@PathVariable("courseId") int courseId) {
        return courseService.getCourseById(courseId);
    }

    @PostMapping("/professors/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/professors/courses/{courseId}")
    public Course updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/professors/courses/{courseId}")
    public void deleteCourse(@PathVariable int courseId) {
        courseService.deleteCourse(courseId);
    }

    @GetMapping("/courses/{courseId}/professor")

    public Professor getProfessorCourse(@PathVariable("courseId") int courseId) {
        return courseService.getProfessorCourse(courseId);
    }

    @GetMapping("/courses/{courseId}/students")

    public List<Student> getStudentCourses(@PathVariable("courseId") int courseId) {
        return courseService.getStudentCourses(courseId);
    }

}