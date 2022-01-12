package hu.course.model.domain;

public class Course {

    private final String teacher;
    private final String subject;
    private final String classId;
    private final int weeklyLessonNumber;

    public Course(String teacher, String subject, String classId, int weeklyLessonNumber) {
        this.teacher = teacher;
        this.subject = subject;
        this.classId = classId;
        this.weeklyLessonNumber = weeklyLessonNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassId() {
        return classId;
    }

    public int getWeeklyLessonNumber() {
        return weeklyLessonNumber;
    }
}
