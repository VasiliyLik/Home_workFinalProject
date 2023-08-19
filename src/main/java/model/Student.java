package model;

import enums.Faculties;
import interfacesAndAnnotations.MyAnnotationForGenerate;

import java.util.Objects;

public class Student extends Person implements Comparable<Student> {
    @MyAnnotationForGenerate
    private int age;
    @MyAnnotationForGenerate
    private Faculties faculty;
    @MyAnnotationForGenerate
    private boolean freePaidEducation;
    @MyAnnotationForGenerate
    private double averageScore;

    public Student(String firstName, String surName, int age, Faculties faculty, boolean freePaidEducation, double averageScore) {
        super(firstName, surName);
        this.age = age;
        this.faculty = faculty;
        this.freePaidEducation = freePaidEducation;
        this.averageScore = averageScore;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }

    public Faculties getFaculty() {
        return faculty;
    }

//    public void setFaculty(Faculties faculty) {
//        this.faculty = faculty;
//    }

    public boolean isFreePaidEducation() {
        return freePaidEducation;
    }

//    public void setFreePaidEducation(boolean freePaidEducation) {
//        this.freePaidEducation = freePaidEducation;
//    }

    public double getAverageScore() {
        return averageScore;
    }

//    public void setAverageScore(double averageScore) {
//        this.averageScore = averageScore;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && isFreePaidEducation() == student.isFreePaidEducation() && Double.compare(student.getAverageScore(), getAverageScore()) == 0 && getFaculty() == student.getFaculty();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getFaculty(), isFreePaidEducation(), getAverageScore());
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + getFirstName() + '\'' +
                ", surName=" + getSurName() + '\'' +
                ", age=" + age +
                ", faculty=" + faculty +
                ", freePaidEducation=" + freePaidEducation +
                ", averageScore=" + averageScore +
                '}';
    }

    @Override
    public int compareTo(Student anotherStudent) {
        return Double.compare(this.averageScore, anotherStudent.averageScore);
    }
}
