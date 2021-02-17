package basicAlgorithm;

import java.util.Scanner;

/**
 * 두 변수 a,b에 정수를 입력하고 b - a를 출력하는 프로그램 작성.단, b >= a
* */
class doWhile_p1 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 값：");
        int a = stdIn.nextInt();

        int b=0;
        while (true) {
            System.out.print("b의 값：");
            b = stdIn.nextInt();
            if (b > a)
                break;
            System.out.println("a보다 큰 값을 입력하세요!");
        }

        System.out.println("b - a는 " + (b - a) + "입니다.");
    }
}
/**
 * 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성하세요. 예를 들어 135를 입력하면 '그 수는 3자리입니다.'라고 출력하고
 * 1314를 입력하면 그 수는 4자리입니다.라고 출력하면 됩니다.
 * */
class doWhile_p2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int posNumber;

        do {
            System.out.print("양의 정수를 입력: ");
            posNumber = scanner.nextInt();
        } while(posNumber < 0);

        String countNumber = String.valueOf(posNumber);
        System.out.println("자리 수는 " + countNumber.length() + "입니다.");

    }
}