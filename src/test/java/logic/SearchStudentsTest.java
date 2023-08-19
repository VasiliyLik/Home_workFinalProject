package logic;

import enums.Faculties;
import model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static logic.StudentBase.studentList;

public class SearchStudentsTest {
    SearchStudents searchStudents = new SearchStudents();
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;
    private Student student6;

    @Before
    public void createStudentBase() {
        studentList = new ArrayList<>();
        student1 = new Student("Ban", "Johns", 21, Faculties.ECONOMICS, true, 7.6);
        student2 = new Student("Roy", "Stick", 20, Faculties.HISTORY, false, 7.1);
        student3 = new Student("Chuck", "Lee", 26, Faculties.LAW, true, 9.4);
        student4 = new Student("Nick", "Busch", 19, Faculties.ECONOMICS, false, 8.9);
        student5 = new Student("Sam", "Wolf", 23, Faculties.LAW, false, 7.4);
        student6 = new Student("Vaso", "Vlasov", 31, Faculties.HISTORY, false, 9.3);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
    }

    @Test
    public void searchingBySurname() {
        List<Student> expected = searchStudents.searchingBySurname("Lee");
        List<Student> actual = new ArrayList<>();
        actual.add(student3);
        Assert.assertArrayEquals(new List[]{expected}, new List[]{actual});
    }

    @Test
    public void searchingByRangeAverageScore() {
        List<Student> expected = searchStudents.searchingByRangeAverageScore(8.6, 9.0);
        List<Student> actual = new ArrayList<>();
        actual.add(student4);
        Assert.assertArrayEquals(new List[]{expected}, new List[]{actual});
    }
}