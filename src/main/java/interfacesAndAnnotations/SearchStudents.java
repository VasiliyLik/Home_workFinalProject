package interfacesAndAnnotations;

import model.Student;

import java.util.List;

public interface SearchStudents {
    List<Student> searchingBySurname(String searchSurName);

    List<Student> searchingByRangeAverageScore(Double a, Double b);
}
