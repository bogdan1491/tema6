package ro.homework_exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger LOGGER = Logger.getLogger(Student.class.getName());

    public static void main(String[] args) {
        Student people = new Student();
        people.addNewStudent("Mihai", "Serbian", 1990, "male", "1902154789652");
        people.addNewStudent("Anton", "Serban", 1993, "male", "1932547895412");
        people.addNewStudent("Iulian", "Racovita", 1993, "male", "1932547854123");

        System.out.println("The students from the list are: ");
        people.listStudent();

        System.out.println();
        System.out.println("The student found by age is: ");
        people.findByAge(28);
        System.out.println("____________________________________________________________________________________________");

        try {
            try {
                people.addNewStudent("", "Craciune", 1957, "male", "1576587458956");
            } catch (ValidationException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, "something went wrong");
            }
            try {
                people.addNewStudent("Ion", "", 1957, "male", "1576587458956");
            } catch (ValidationException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, "something went wrong");
            }
            try {
                people.addNewStudent("Ion", "Craciune", 1899, "male", "1576587458956");
            } catch (ValidationException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, "something went wrong");
            }
            try {
                people.addNewStudent("Ion", "Craciune", 1957, "masculin", "1576587458956");
            } catch (ValidationException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, "something went wrong");
            }
            try {
                people.deleteStudentById("193254789541");
            } catch (ValidationException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, "something went wrong");
            }
            try {
                people.findByAge(-9);
            } catch (ValidationException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, "something went wrong");
            }
            try {
                people.deleteStudentById("1902154789657");
            } catch (ValidationException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, "something went wrong");
            }
        } finally {

        }
    }

}
