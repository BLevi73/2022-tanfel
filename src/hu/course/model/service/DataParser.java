package hu.course.model.service;

import hu.course.model.domain.Course;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataParser {

    public List<Course> parse(List<String> lines) {
        return IntStream.iterate(0, i -> i + 4).limit(lines.size() / 4)
                .mapToObj(i -> createCourse(lines.subList(i, i + 4)))
                .collect(Collectors.toList());
    }

    private Course createCourse(List<String> lines) {
        String teacher = lines.get(0);
        String subject = lines.get(1);
        String classId = lines.get(2);
        int weeklyLessonNumber = Integer.parseInt(lines.get(3));
        return new Course(teacher, subject, classId, weeklyLessonNumber);
    }
}
