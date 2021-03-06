package registrar;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bjackson on 2/21/2016.
 */
public class Student {

    public String name;
    public Set<Course> courses;

    /**
     * Creates a new student with an empty set of classes they are enrolled in
     */
    public Student(){
        courses = new HashSet<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<Course> getCourses(){
        return courses;
    }

    /**
     * Enrolls this student in a course, adding the student to course list and the course to student's list
     * @param course course to be added
     * @return true if worked, false if student could not be added (in which case student was put on wait list)
     */
    public boolean enrollIn(Course course){
        if(course.enrollStudent(this)) {
            courses.add(course);
            return true;
        }
        return false;
    }

    /**
     * Drops a course from the student's enrolled courses and removes the student from the course enrollment list
     * @param course Course student is to be removed from
     */
    public void drop(Course course){
        if (courses.contains(course)) {
            courses.remove(course);
        }
        course.dropStudent(this);
    }
}
