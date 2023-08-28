package logic;

import enums.Faculties;
import interfacesAndAnnotations.DisplayFaculties;
import model.Student;
import org.apache.commons.math3.util.Pair;
import org.apache.commons.math3.util.Precision;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static logic.StudentBase.studentList;

public class FacultyBase implements DisplayFaculties {
    static List<Faculties> facultiesList = null;

    //отображение списка факультетов
    public List<Faculties> printFaculty() {
        facultiesList = List.of(Faculties.values());
        return facultiesList;
    }

    //вывод факультетов в порядке успеваемости студентов
    @Override
    public Map<Double, Faculties> displayFacultiesRating() {
        double sumE = 0, sumH = 0, sumL = 0;
        for (Student st : studentList) {
            if (st.getFaculty().equals(Faculties.ECONOMICS)) {
                sumE += st.getAverageScore();
            }
            if (st.getFaculty().equals(Faculties.HISTORY)) {
                sumH += st.getAverageScore();
            }
            if (st.getFaculty().equals(Faculties.LAW)) {
                sumL += st.getAverageScore();
            }
        }
        TreeMap<Double, Faculties> treeMap = new TreeMap<>();
        treeMap.put(sumE, Faculties.ECONOMICS);
        treeMap.put(sumH, Faculties.HISTORY);
        treeMap.put(sumL, Faculties.LAW);

        return treeMap.descendingMap();
    }

    // % соотношение бюджетников и платников в рамках информации о факультетах
    @Override
    public Pair<Double, Double> displayPercentagePaidEducation() {
        int freePaidCount = 0, paidCount = 0;
        double freePaidPercentage, paidPercentage;
        for (Student st : studentList) {
            if (st.isFreePaidEducation()) {
                freePaidCount++;
            } else {
                paidCount++;
            }
        }
        freePaidPercentage = (double) freePaidCount / studentList.size() * 100;
        paidPercentage = (double) paidCount / studentList.size() * 100;
        return new Pair<>(Precision.round(freePaidPercentage, 2), (Precision.round(paidPercentage, 2)));
    }

    //Отобразить средний бал среди бюджетников и среди платников в рамках информации о факультетах
    @Override
    public Pair<Double, Double> displayAverageScoreForPaidEducation(Faculties faculties) {
        int count1 = 0, count2 = 0;
        double f1 = 0.0, f2 = 0.0;
        for (Student st : studentList) {
            if (st.getFaculty().equals(faculties) && st.isFreePaidEducation()) {
                count1++;
                f1 += st.getAverageScore();
            } else if (st.getFaculty().equals(faculties) && !(st.isFreePaidEducation())) {
                count2++;
                f2 += st.getAverageScore();
            }
        }
        double result = f1 / count1;
        double result2 = f2 / count2;
        return new Pair<>(result, result2);
    }
}
