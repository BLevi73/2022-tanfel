package hu.course;

import hu.course.controller.CourseService;
import hu.course.model.service.*;

import java.util.Scanner;

public class App {

    private final CourseService courseService;
    private final Console console;
    private final DataWriter dataWriter;

    private App() {
        DataApi dataApi= new DataApi(new FileReader(), new DataParser());
        courseService = new CourseService(dataApi.getData("beosztas.txt"));
        console = new Console(new Scanner(System.in));
        dataWriter = new DataWriter("of.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2.feladat:");
        System.out.println("A fájlban " + courseService.getCourseCount() + " bejegyzés van.");
        System.out.println("3.feladat;");
        System.out.println("Az iskolában a heti óraszám: " + courseService.getTotalLessonCount());
        System.out.println("4.feladat:");
        System.out.print("Egy tanár neve: ");
        String name = console.read();
        System.out.println("A tanár heti óraszáma: " + courseService.getTeacherWeeklyLesson(name));
        dataWriter.write(courseService.getMasterTeachers());
        System.out.println("6.feladat:");
        System.out.print("Osztály: ");
        String classId = console.read();
        System.out.print("Tantárgy: ");
        String subject = console.read();
        System.out.println(courseService.getCourseStatus(subject, classId));
        System.out.println("7.feladat: ");
        System.out.println("Az iskolában " + courseService.getTeacherCount() + " tanár tanít.");
    }

}
