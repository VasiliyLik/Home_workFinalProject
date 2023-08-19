package logic;

import enums.Faculties;
import interfacesAndAnnotations.MyAnnotationForGenerate;
import model.Student;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Scanner;

//класс с методом по созданию студента через рефлексию с применением кастомной аннотации
public class CreateStudentUsingReflection {

    public void createStudent(Object object) throws IllegalAccessException {
        final Class<?> clazz = object.getClass();
        final Class<?> superclass = clazz.getSuperclass();
        final Field[] fields = getAllFields(object);
        for (Field field : fields) {
            Annotation annotation = field.getDeclaredAnnotation(MyAnnotationForGenerate.class);
            if (annotation == null) {
                continue;
            }
            try {
                if (field.equals(superclass.getDeclaredField("firstName"))) {
                    field.setAccessible(true);
                    field.set(object, generateStringFirstName());
                }

                if (field.equals(superclass.getDeclaredField("surName"))) {
                    field.setAccessible(true);
                    field.set(object, generateStringSurName());
                }
                if (field.equals(clazz.getDeclaredField("age"))) {
                    field.setAccessible(true);
                    field.set(object, generateAge());
                }
                if (field.equals(clazz.getDeclaredField("faculty"))) {
                    field.setAccessible(true);
                    field.set(object, generateFaculty());
                }
                if (field.equals(clazz.getDeclaredField("freePaidEducation"))) {
                    field.setAccessible(true);
                    field.set(object, generateFreePaidEducation());
                }
                if (field.equals(clazz.getDeclaredField("averageScore"))) {
                    field.setAccessible(true);
                    field.set(object, generateAverageScore());
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        StudentBase.studentList.add((Student) object);
        System.out.println(StudentBase.studentList);
    }

    //метод, формирующий массив полей класса-родителя и наследника
    public static Field[] getAllFields(Object o) {
        Class<?> c = o.getClass();
        Field[] fields = {};
        while (c != null) {
            fields = ArrayUtils.addAll(fields, c.getDeclaredFields());
            c = c.getSuperclass();
        }
        return fields;
    }

    private String generateStringFirstName() {
        System.out.println("Input firstName");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String generateStringSurName() {
        System.out.println("Input surName");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int generateAge() {
        System.out.println("Input age");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private Faculties generateFaculty() {
        System.out.println("Input Faculty");
        Scanner scanner = new Scanner(System.in);
        return Faculties.valueOf(scanner.nextLine().toUpperCase());
    }

    private Boolean generateFreePaidEducation() {
        System.out.println("Input paid education");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextBoolean();
    }

    private double generateAverageScore() {
        System.out.println("Input average score");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
