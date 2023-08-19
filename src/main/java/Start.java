import enums.Faculties;
import logic.*;
import model.Student;

public class Start {

    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        StudentBase studentBase = StudentBase.getInstance();
        studentBase.createStudentBase();
        studentBase.createStudent();

        studentBase.createStudentsJsonFile("src//main//java//files//studentsJsonFile2.json");
        System.out.println("------------");

        studentBase.sortByAverageScore();
        System.out.println("------------");

        SearchStudents searchingStudents = new SearchStudents();
        System.out.println("Searched student: " + searchingStudents.searchingBySurname("Lee"));
        System.out.println("------------");

        System.out.println(searchingStudents.searchingByRangeAverageScore(7.5, 9.2));
        System.out.println("------------");

        FacultyBase facultyBase = new FacultyBase();
        facultyBase.printFaculty();
        System.out.println("------------");

        System.out.println("Faculty Ranking by Student Performance: " + facultyBase.displayFacultiesRating());
        System.out.println("------------");

        System.out.println("Ratio of free paid and paid students: " + facultyBase.displayPercentagePaidEducation()); //33.33  66.67
        System.out.println("------------");

        System.out.println("This Faculty's average Score: with free-paid & paid "
                + facultyBase.displayAverageScoreForPaidEducation(Faculties.LAW));// free paid - 9.4, paid - 7.4

        Student student = new Student();
        CreateStudentUsingReflection usingReflection = new CreateStudentUsingReflection();
        usingReflection.createStudent(student);
        System.out.println("------------");

        ReadFilesThreads readFilesThreads = new ReadFilesThreads();
        readFilesThreads.readFiles();
        Thread.sleep(1000);

        ReadFilesFromURL fromURL = new ReadFilesFromURL();
        System.out.println(fromURL.getJSONFromURL("https://raw.githubusercontent.com/VasiliyLik/Home_work10JSON/main/patientFromConsoleGsonFile.json"));

    }
}
