package logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import enums.Faculties;
import interfacesAndAnnotations.ConsoleInputStudents;
import model.BooleanSerializer;
import model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//класс StudentBase c паттерном Singleton
public class StudentBase implements ConsoleInputStudents {
      private static StudentBase instance;

    public static synchronized StudentBase getInstance() {
        if (instance == null) {
            instance = new StudentBase();
        }
        return instance;
    }

    public static List<Student> studentList;

    //создаем лист студентов
    public List<Student> createStudentBase() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Ban", "Johns", 21, Faculties.ECONOMICS, true, 7.6));
        studentList.add(new Student("Roy", "Stick", 20, Faculties.HISTORY, false, 7.1));
        studentList.add(new Student("Chuck", "Lee", 26, Faculties.LAW, true, 9.4));
        studentList.add(new Student("Nick", "Busch", 19, Faculties.ECONOMICS, false, 8.9));
        studentList.add(new Student("Sam", "Wolf", 23, Faculties.LAW, false, 7.4));
        studentList.add(new Student("Vaso", "Vlasov", 31, Faculties.HISTORY, true, 9.3));
        studentList.sort(Comparator.comparing(Student::getSurName));
        return studentList;
    }

    //создаем студента через консоль
    @Override
    public void createStudent() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("input firstName");
            final String firstName = scanner.nextLine();
            System.out.println("input surName");
            final String surName = scanner.next("\\S{1,15}");
            System.out.println("input age");
            final int age = Integer.parseInt(scanner.next("\\d{2}"));
            scanner.nextLine();
            Faculties faculty = null;
            System.out.println("input faculty");
            final String faculties = scanner.nextLine().toUpperCase();
            if (faculties.equals(Faculties.ECONOMICS.toString())) {
                faculty = Faculties.ECONOMICS;
            } else if (faculties.equals(Faculties.HISTORY.toString())) {
                faculty = Faculties.HISTORY;
            } else if (faculties.equals(Faculties.LAW.toString())) {
                faculty = Faculties.LAW;
            } else {
                System.out.println("Incorrect input of faculty");
            }
            System.out.println("input free paid education: true or false");
            final boolean freePaidEducation = scanner.nextBoolean();
            System.out.println("input averageScore");
            final double averageScore = scanner.nextDouble();
            Student student = new Student(firstName, surName, age, faculty, freePaidEducation, averageScore);

            studentList.add(student);

            studentList.sort(Comparator.comparing(Student::getSurName));
            for (Student list : studentList) {
                System.out.println(list);
            }
        } catch (Exception e) {
            System.out.println("Incorrect data input!");
        }
    }

    //создаем json файл со списком студентов
    public void createStudentsJsonFile(String filePath) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath))) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Boolean.class, new BooleanSerializer());
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            String json = gson.toJson(studentList);
            printWriter.write(json);
            System.out.println("Created json file: " + json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //сортировка студентов по среднему баллу
    public List<Student> sortByAverageScore() {
        studentList.sort(new AverageScoreComparator());
        return studentList;
    }
}

//компаратор для сортировки студентов по среднему баллу
class AverageScoreComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student1.getAverageScore(), student2.getAverageScore());
    }
}





