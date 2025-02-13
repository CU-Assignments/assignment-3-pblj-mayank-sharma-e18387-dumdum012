import java.util.InputMismatchException;
import java.util.Scanner;

// Hard Level: University Enrollment System
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class UniversityEnrollment {
    private static final int MAX_STUDENTS = 2;
    private int enrolledStudents = 0;

    public void enrollStudent(String course, boolean hasPrerequisite) throws CourseFullException, PrerequisiteNotMetException {
        if (!hasPrerequisite) {
            throw new PrerequisiteNotMetException("Complete prerequisite before enrolling in " + course);
        }
        if (enrolledStudents >= MAX_STUDENTS) {
            throw new CourseFullException(course + " is already full.");
        }
        enrolledStudents++;
        System.out.println("Successfully enrolled in " + course);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniversityEnrollment enrollment = new UniversityEnrollment();

        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();
            System.out.print("Prerequisite completed? (yes/no): ");
            String prerequisiteInput = scanner.nextLine();
            boolean hasPrerequisite = prerequisiteInput.equalsIgnoreCase("yes");

            enrollment.enrollStudent(course, hasPrerequisite);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
