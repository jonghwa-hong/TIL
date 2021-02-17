package basicAlgorithm;

import java.util.Scanner;

// 논리 연산과 드모르간 법치
public class Digits {
    // 2자리 양수(10 ~ 99)를 ㅣㅇㅂ력한다.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int no;

        System.out.println("2자리 정수를 입력하세요. ");

        do {
            System.out.println("입력: ");
            no = scanner.nextInt();
        } while (no <10 || no >99);

        System.out.println("변수 no의 값은 " + no + "가 되었습니다.");
    }
}
