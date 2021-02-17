package basicAlgorithm;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
* 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하세요
* */
public class SumOf {

    static int sumOf(int a, int b) {
        for (int i = a; i <= b; i++) {
            a += i;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("첫 번째 값: ");
        int num1 = scan.nextInt();
        System.out.print("두 번째 값: ");
        int num2 = scan.nextInt();
        System.out.println(num1 + "부터 " + num2 + "까지의 합: " + sumOf(num1, num2));
    }
}
