import enums.Faculties;
import logic.*;
import model.Student;

import java.util.Scanner;

public class CaseMenu {
    final String FILE_PATH = "src//main//java//files//";
    Student student = new Student();
    StudentBase studentBase = StudentBase.getInstance();
    SearchStudents searchingStudents = new SearchStudents();
    FacultyBase facultyBase = new FacultyBase();
    CreateStudentUsingReflection usingReflection = new CreateStudentUsingReflection();
    ReadFilesFromURL fromURL = new ReadFilesFromURL();
    private final Scanner scanner;

    public CaseMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1. список студентов;");
        System.out.println("2. создание студента и добавление в общий список;");
        System.out.println("3. запись списка студентов в файл json;");
        System.out.println("4. сортировка студентов по среднему баллу;");
        System.out.println("5. поиск студента по фамилии;");
        System.out.println("6. поиск студентов по диапазону среднего балла;");
        System.out.println("7. отображение списка факультетов;");
        System.out.println("8. рейтинг факультетов по успеваемости студентов;");
        System.out.println("9. соотношение бюджетников и платников в рамках информации о факультетах;");
        System.out.println("10. просмотр среднего балла среди бюджетников и среди платников в рамках факультетов;");
        System.out.println("11. создание студента с использованием рефлексии и добавление в список;");
        System.out.println("12. чтение файла из интернета;");
        System.out.println("13. выход из программы");
    }

    public void start() {
        studentBase.createStudentBase();
        Faculties faculties;
        try {
            if (this.scanner != null) {
                int key;
                do {
                    printMenu();
                    System.out.print("Введите номер меню: ");
                    key = this.scanner.nextInt();
                    switch (key) {
                        case 1:
                            System.out.println("List of students:");
                            studentBase.createStudentBase().forEach(System.out::println);
                            break;
                        case 2:
                            studentBase.createStudent();
                            break;
                        case 3:
                            System.out.println("Input file's name:");
                            String fileName = scanner.next();
                            studentBase.createStudentsJsonFile(FILE_PATH + fileName);
                            break;
                        case 4:
                            System.out.println("Sorting students by grade point average:");
                            studentBase.sortByAverageScore().forEach(System.out::println);
                            break;
                        case 5:
                            System.out.println("Input surName:");
                            searchingStudents.searchingBySurname(scanner.nextLine());
                            System.out.println("Searched student: " + searchingStudents.searchingBySurname(scanner.nextLine()));
                            break;
                        case 6:
                            System.out.println("Input a range, from ...(click 'Enter'), than Input to ... ");
                            searchingStudents.searchingByRangeAverageScore(scanner.nextDouble(), scanner.nextDouble()).forEach(System.out::println);
                            break;
                        case 7:
                            System.out.println("List of faculties:" + facultyBase.printFaculty());
                            break;
                        case 8:
                            System.out.println("Faculty Ranking by Student Performance: " + facultyBase.displayFacultiesRating());
                            break;
                        case 9:
                            System.out.println("Ratio of free paid and paid students: " + facultyBase.displayPercentagePaidEducation());
                            break;
                        case 10:
                            System.out.println("Input faculty:");
                            faculties = Faculties.valueOf(scanner.next().toUpperCase());
                            facultyBase.displayAverageScoreForPaidEducation(faculties);
                            System.out.println("This Faculty's average Score: with free-paid & paid "
                                    + facultyBase.displayAverageScoreForPaidEducation(faculties));
                            break;
                        case 11:
                            usingReflection.createStudent(student);
                            break;
                        case 12:
                            System.out.println("Input URL address:");
                            System.out.println(fromURL.getJSONFromURL(scanner.next()));
                            break;
                        case 13:
                            System.out.println("завершение программы...");
                            break;
                        default:
                            System.out.println("вы ввели неверное значение меню...\n");
                    }
                } while (key != 13);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
