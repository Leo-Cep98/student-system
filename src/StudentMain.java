import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner capture = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>() ;
        String addNext;
        int age;
        double grade;

        do {
            System.out.println("\n📑 Creating a new Student...");
            Thread.sleep(1200);

            System.out.println("\n🥸Enter the name: ");
            String name = capture.nextLine();

            try {
                System.out.println("\n🎂Enter the age: ");
                age = capture.nextInt();
            } catch (InputMismatchException e){
                System.out.println("⚠️ Oops! You entered something invalid. Setting age = 5 and grade = 0.0 as default.");
                age = 5;
                grade = 0.0;
            }
            try {
                System.out.println("\n📊Enter the grade: ");
                grade = capture.nextDouble();
            }catch (InputMismatchException e){
                grade = 0.0;
            }
            capture.nextLine();
            System.out.println("\n📑 Saving data please wait...");
            Thread.sleep(2500);

            students.add(new Student(name,age,grade));

            System.out.println("\nData saved successfully ✅");

            System.out.println("\n🆕 Do you want to add a new student?\nIf so please type YES otherwise type NO ");
            addNext = capture.nextLine().toLowerCase();

        }while (addNext.equals("yes"));
        System.out.println("\n🔎 Enter the ID of the student you want to find:");
        int idToLook = capture.nextInt();
        Student found = Student.findStudentById(students, idToLook);
        if (found != null){
            System.out.println("\n🥳 Student was found");
            found.showInfo();
        }else {
            System.out.println("\n ⚠ The ID given does not match any student on the system");
        }

        for (Student person:students){
            person.showInfo();
        }

        Student.showTotalStudents();
    }
}
