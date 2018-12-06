package ro.homework_exceptions;

import java.util.*;
import java.util.logging.Logger;

public class Student {
    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private String gender;
    private String id;
    private int currentYear = 2018;
    private int age;
    private List<Student> studentList = new ArrayList<>();


    public Student() {

    }

    public Student(String firstName, String lastName, int dateOfBirth, String gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;

    }

    public void addNewStudent(String firstName, String lastName, int dateOfBirth, String gender, String id) throws ValidationException {
        studentList.add(new Student(firstName, lastName, dateOfBirth, gender, id));
        if (firstName.length() < 1) {
            throw new ValidationException("Insert first name");
        }
        if (lastName.length() < 1) {
            throw new ValidationException("Insert last name");
        }
        if (dateOfBirth < 1900 || dateOfBirth > currentYear) {
            throw new ValidationException("Date of birth should be between 1900 and " + currentYear + ")");
        }
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") ||
                gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
            this.gender = gender;
        } else {
            throw new ValidationException("Insert gender (i.e: Male, male, M or Female, female, F)");
        }

    }

    public void listStudent() {
        for (Student s : studentList) {
            System.out.println(s);
        }

    }

    public boolean deleteStudentById(String id) throws ValidationException {

        if (!studentList.contains(id)) {
            throw new ValidationException("Student doesn't exist");
        }

        if (id == null) {
            throw new ValidationException("Insert CNP");
        }
        if (id.length() != 13) {
            throw new ValidationException("CNP should have 13 digits");
        }
        boolean result = false;
        Student s = findById(id);

        if (s != null) {
            result = studentList.remove(s);
        }

        return result;
    }


    public Student findById(String id) {
        Student result = null;
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                result = s;
                break;
            }
        }
        return result;
    }

    public Student findByAge(int age) throws ValidationException {
        if (age != (int) age) {
            throw new ValidationException("The age should consisting of figures");
        }
        if (age < 0) {
            throw new ValidationException("The age cannot be negative");
        }
        Student result = null;
        for (Student s : studentList) {
            if (s.getDateOfBirth() == (currentYear - age)) {
                result = s;
                System.out.println(s);
            }
        }
        return result;
    }

    public void listByName() {
        Set<Student> studentByName = new TreeSet<>(new NameComparator());
        studentByName.addAll(studentList);
        Iterator it = studentByName.iterator();
        System.out.println("The students sorted by name are: ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }


    public int getDateOfBirth() {
        return dateOfBirth;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return dateOfBirth == student.dateOfBirth &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                gender.equals(student.gender) &&
                id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, gender, id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
