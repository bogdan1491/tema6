package ro.homework_exceptions;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

}
