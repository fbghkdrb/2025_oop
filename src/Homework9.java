import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Homework9 {
    public static HashMap<String, String> loadUsersFromFile(String filename) {
        HashMap<String, String> userMap = new HashMap<>();
        File file = new File(filename);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 2) {
                    userMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("오류: " + filename + " 파일을 찾을 수 없습니다.");
            e.printStackTrace();
        }
        return userMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> userMap = loadUsersFromFile("db.txt");

        if (userMap.isEmpty()) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String inputId;
        String inputPassword;

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