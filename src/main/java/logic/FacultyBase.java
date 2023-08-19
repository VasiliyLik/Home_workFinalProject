package logic;

import enums.Faculties;
import interfacesAndAnnotations.DisplayFaculties;
import model.Student;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import static logic.StudentBase.studentList;

public class FacultyBase implements DisplayFaculties {
    static List<Faculties> facultiesList = null;

    //отображение списка факультетов
    public void printFaculty() {
        facultiesList = new ArrayList<>();
        facultiesList.add(Faculties.ECONOMICS);
        facultiesList.add(Faculties.HISTORY);
        facultiesList.add(Faculties.LAW);
        System.out.println("List of faculties:");
        for (Faculties f : facultiesList) {
            System.out.println(f);
        }
    }

    //вывод факультетов в порядке успеваемости студентов
    @Override
    public NavigableMap<Double, Faculties> displayFacultiesRating() {
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
    public List<Double> displayPercentagePaidEducation() {
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
        List<Double> persentage = new ArrayList<>();
        persentage.add(Precision.round(freePaidPercentage, 2));
        persentage.add(Precision.round(paidPercentage, 2));
        return persentage;
    }

    //Отобразить средний бал среди бюджетников и среди платников в рамках информации о факультетах
    @Override
    public List<Double> displayAverageScoreForPaidEducation(Faculties faculties) {
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
        List<Double> kindOfEducation = new ArrayList<>();
        kindOfEducation.add(result);
        kindOfEducation.add(result2);
        return kindOfEducation;
    }
}
