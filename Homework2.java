import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Student {
    private long studentId;
    private String name;
    private String major;
    private long phoneNum;

    public Student(long studentId, String name, String major, long phoneNum) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.phoneNum = phoneNum;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getPhoneNumFormatted() {
        String numStr = Long.toString(this.phoneNum);

        if (numStr.length() == 10) {
            numStr = "0" + numStr;
        }

        if (numStr.length() == 11) {
            String p1 = numStr.substring(0, 3);
            String p2 = numStr.substring(3, 7);
            String p3 = numStr.substring(7);
            return p1 + "-" + p2 + "-" + p3;
        }

        return numStr;
    }
}
public class Homework2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        final int NUM_STUDENTS = 3;

        for (int i = 0; i < NUM_STUDENTS; i++) {
            System.out.print("학생의 학번, 이름, 전공, 전화번호를 입력하세요: ");

            long studentId = scanner.nextLong();
            String name = scanner.next();
            String major = scanner.next();
            long phoneNum = scanner.nextLong();

            Student student = new Student(studentId, name, major, phoneNum);
            students.add(student);
        }

        scanner.close();

        System.out.println("입력된 학생들의 정보는 다음과 같습니다.");
        String[] titles = {"첫번째 학생", "두번째 학생", "세번째 학생"};

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);

            System.out.print(titles[i] + ": ");
            System.out.print(student.getStudentId() + " ");
            System.out.print(student.getName() + " ");
            System.out.print(student.getMajor() + " ");
            System.out.println(student.getPhoneNumFormatted());
        }
    }
}