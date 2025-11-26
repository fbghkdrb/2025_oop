import java.util.HashMap;
import java.util.Scanner;

public class Homework8 {
    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<>();
        userMap.put("myId", "myPass");
        userMap.put("myId2", "myPass2");
        userMap.put("myId3", "myPass3");

        Scanner scanner = new Scanner(System.in);
        String inputId = "";
        String inputPassword = "";

        while (true) {
            System.out.println("id와 password를 입력해주세요.");

            System.out.print("id : ");
            inputId = scanner.nextLine().trim();

            if (userMap.containsKey(inputId)) {
                System.out.print("password : ");
                inputPassword = scanner.nextLine().trim();

                String storedPassword = userMap.get(inputId);

                if (inputPassword.equals(storedPassword)) {
                    System.out.println("id와 비밀번호가 일치합니다.");
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                }
            } else {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
            }
        }

        scanner.close();
    }
}