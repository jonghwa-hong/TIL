package basicAlgorithm;

import java.util.Scanner;

// 1, 2, ... , n 의 합을 구한다.(양수만 입력)
public class SumForPos {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;

        System.out.println("1 부터 n 까지의 합을 구한다.");

        do {
            System.out.print("n의 값 : ");
            n = scan.nextInt();
            if (n <= 0) {
                System.out.println("n은 양수이어야 합니다.");
            }
        } while (n <= 0);

        int sum = 0; // 합

        for (int i = 1; i <= n; i++)
            sum += i; // sum 에 i를 더한다.

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");

    }
}
