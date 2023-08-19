package logic;

import model.Student;

import java.util.ArrayList;
import java.util.List;

import static logic.StudentBase.studentList;

public class SearchStudents implements interfacesAndAnnotations.SearchStudents {

    @Override
    public List<Student> searchingBySurname(String searchSurName) {
        List<Student> result = new ArrayList<>();
        for (Student searchStudent : studentList) {
            if (searchSurName.equals(searchStudent.getSurName()))
                result = (List.of(searchStudent));
        }
        return result;
    }

    @Override
    public List<Student> searchingByRangeAverageScore(Double a, Double b) {
        List<Student> result = new ArrayList<>();
        for (Student rangeSt : studentList) {
            if (rangeSt.getAverageScore() >= a && rangeSt.getAverageScore() <= b)
                result.add(rangeSt);
        }
        return result;
    }
}


