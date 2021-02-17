package basicAlgorithm;

import java.util.Scanner;

// 가우스 방식
public class SumGauss {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구하시오");
        System.out.print("n의 값: ");
        int n = sc.nextInt();
        int sum = 0;

        sum = (1 + n) * (n / 2);

        if (n % 2 != 0) {
            sum += (n + 1) / 2;
        }

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    }
}
