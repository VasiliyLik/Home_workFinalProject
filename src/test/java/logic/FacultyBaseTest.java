package logic;

import enums.Faculties;
import model.Student;
import org.apache.commons.math3.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static logic.StudentBase.studentList;

public class FacultyBaseTest {
    FacultyBase facultyBase = new FacultyBase();

    @Before
    public void createStudentBase() {
        studentList = new ArrayList<>();
        Student student1 = new Student("Ban", "Johns", 21, Faculties.ECONOMICS, true, 7.6);
        Student student2 = new Student("Roy", "Stick", 20, Faculties.HISTORY, false, 7.1);
        Student student3 = new Student("Chuck", "Lee", 26, Faculties.LAW, true, 9.4);
        Student student4 = new Student("Nick", "Busch", 19, Faculties.ECONOMICS, false, 8.9);
        Student student5 = new Student("Sam", "Wolf", 23, Faculties.LAW, false, 7.4);
        Student student6 = new Student("Vaso", "Vlasov", 31, Faculties.HISTORY, false, 9.3);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
    }

    @Test
    public void displayFacultiesRating() {
        double sumL = 16.8, sumE = 16.5, sumH = 16.4;
        Map<Double, Faculties> expected = facultyBase.displayFacultiesRating();
        TreeMap<Double, Faculties> actual = new TreeMap<>();
        actual.put(sumL, Faculties.LAW);
        actual.put(sumE, Faculties.ECONOMICS);
        actual.put(sumH, Faculties.HISTORY);

        Assert.assertArrayEquals(new Map[]{expected}, new TreeMap[]{actual});
    }

    @Test
    public void displayPercentagePaidEducation1() {
        double freePaidPercentage = 33.33, paidPercentage = 66.67;
        Pair<Double, Double> expected = facultyBase.displayPercentagePaidEducation();
        Pair<Double, Double> actual = new Pair<>(freePaidPercentage, paidPercentage);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayAverageScoreForPaidEducation() {
        double result = 9.4;
        double result2 = 7.4;
        Pair<Double, Double> expected = facultyBase.displayAverageScoreForPaidEducation(Faculties.LAW);
        Pair<Double, Double> actual = new Pair<>(result, result2);
        Assert.assertEquals(expected, actual);
    }
}