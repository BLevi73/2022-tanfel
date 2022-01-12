package hu.course.controller;

import hu.course.model.domain.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {

    private final List<Course> courses;

    public CourseService(List<Course> courses) {
        this.courses = courses;
    }

    public int getCourseCount() {
        return courses.size();
    }

    public int getTotalLessonCount() {
        return courses.stream()
                .mapToInt(Course::getWeeklyLessonNumber)
                .sum();
    }

    public int getTeacherWeeklyLesson(String name) {
        return courses.stream()
                .filter(i -> i.getTeacher().equals(name))
                .mapToInt(Course::getWeeklyLessonNumber)
                .sum();
    }

    public List<String> getMasterTeachers() {
        return courses.stream()
                .filter(i -> "osztalyfonoki".equals(i.getSubject()))
                .map(course -> String.format("%s - %s)", course.getClassId(),course.getTeacher()))
                .collect(Collectors.toList());
    }

    public String getCourseStatus(String subject, String classId) {
        return getCertainCourseCount(subject, classId) == 1
                ? "Osztályszinten tanulják."
                : "Csoportbontásban tanulják.";
    }

    private long getCertainCourseCount(String subject, String classId) {
        return courses.stream()
                .filter(i -> i.getSubject().equals(subject) && i.getClassId().equals(classId))
                .count();
    }

    public long getTeacherCount() {
        return courses.stream()
                .map(Course::getTeacher)
                .distinct()
                .count();
    }
}
