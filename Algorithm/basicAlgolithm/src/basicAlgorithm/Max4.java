package basicAlgorithm;

import java.util.Scanner;

/**
 * 네 값의 최댓값을 구하시오
 * */
public class Max4 {
    // a, b, c, d의 최댓값을 구하여 반환
    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (max < b) max = b;
        if (max < c) max = c;
        if (max < d) max = d;

        return max;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int a, b, c, d;

        System.out.println("네 정수의 최댓값을 구합니다.");
        System.out.print("a의 값：");
        a = stdIn.nextInt();
        System.out.print("b의 값：");
        b = stdIn.nextInt();
        System.out.print("c의 값：");
        c = stdIn.nextInt();
        System.out.print("d의 값：");
        d = stdIn.nextInt();

        int max = max4(a, b, c, d); 	// a, b, c, d의 최댓값

        System.out.println("최댓값은 " + max + "입니다.");
    }
}

