package hu.course.controller;

import hu.course.model.domain.Course;

import java.util.List;

public class CourseService {

    private final List<Course> courses;

    public CourseService(List<Course> courses) {
        this.courses = courses;
    }

    public int getCourseCount() {
        return courses.size();
    }
}
