import java.util.Scanner;

public class Homework4 {
    public static int gcd(int m, int n) {
        if (m < n) {
            return gcd(n, m);
        }
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }

    public static int gcdLoop(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (n != 0) {
            int remainder = m % n;
            m = n;
            n = remainder;
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("두 수를 입력하세요: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int a = Math.abs(num1);
        int b = Math.abs(num2);

        int resultRec = gcd(a, b);
        System.out.printf("두 수의 최대공약수는 %d입니다.\n", resultRec);

        int resultLoop = gcdLoop(a, b);
        System.out.printf("두 수의 최대공약수는 %d입니다.\n", resultLoop);
    }
}
