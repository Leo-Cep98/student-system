import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    private double grade;
    private static int nextId = 1;
    private final int id;
    private boolean isApproved;
    private static int totalStudents=0;
    private String gradeWarning = "";


    public Student(String name, int age, double grade){
        this.id=nextId++;
        ++totalStudents;
        this.name=name;
        setAge(age);
        setGrade(grade);
    }
    public Student(){
        this("Unknown",5,0.00);
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public int getId() {
        return id;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age <0 || age > 90){
            this.age=5;
        }else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setGrade(double grade) {
        if (grade < 0.00 || grade >5.00){
            this.gradeWarning = "\n⚠️⚠️! Invalid grade. Setting it to default (0.00) for the student⚠️⚠️: "+this.name+" 🆔ID: "+this.id;
            this.grade=0.00;
        }else {
            this.grade = grade;
        }
        this.isApproved=this.grade >= 3.5;
    }

    public double getGrade() {
        return grade;
    }
    private String getStatus(){
        if(grade < 3.50f){
            return "📕 Failed!❌";
        } else if (grade <= 4.50f) {
            return "📘 Pass ✍️";
        } else {
            return "📗 Awesome performance ⭐⭐⭐";
        }

    }

    void showInfo(){
        System.out.printf("\n\nThe data of the student is...\n🆔 ID: %d\n🥸 Name: %s\n🎂 Age: %d\n📊 Grade: %.2f\nApproved: %b\n📌Status: %s",getId(),getName(),getAge(),getGrade(),isApproved,getStatus());
        if (!gradeWarning.isEmpty()){
            System.out.println(gradeWarning);
        }
    }
    public static void showTotalStudents(){
        System.out.println("\n\n🏫Total students at school: "+getTotalStudents());
    }
    public static Student findStudentById(ArrayList<Student> students, int idToFind){
        for (Student studentToFind : students){
            if (studentToFind.getId() == idToFind){
                return  studentToFind;
            }
        }
        return null;
    }
}
