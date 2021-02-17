package basicAlgorithm;

import java.util.Scanner;

/**
* 직각 이등변 삼각형을 출력하는 부분을 아래와 같은 형식의 메소드로 작성
 */
class nextedLoop_p1 {
    static void triangleLB(int n) {
        System.out.println("------ LB ------");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleLU(int n) {
        System.out.println("------ LU ------");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void triangleRB(int n) {
        System.out.println("------ RB ------");
        String blank = " ";
        String star = "*";
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(blank);
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(star);
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        System.out.println("------ RU ------");
        for (int i = n; i >= 1; i--) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("다양한 형식의 직각 이등변 삼각형: ");
        int n = scanner.nextInt();
        triangleLB(n);
        triangleLU(n);
        triangleRB(n);
        triangleRU(n);
    }
}

/**
 * n단의 피라미드 출력 메소드 작성
 */
class nextedLoop_p2 {

    static void spira(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i + 1; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("피라미드 모양으로 나타냅니다.");

        do {
            System.out.print("단수는 ：");
            n = stdIn.nextInt();
        } while (n <= 0);

        spira(n); 		// 피라미드를 나타냄
    }
}

/**
 * n 단의 숫자 피라미드 작성
 */
class nextedLoop_p3 {

    static void npira(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i + 1; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i) + 1; j++) {
                System.out.print(count);
            }
            System.out.println();
            count++;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("피라미드 모양으로 나타냅니다.");

        do {
            System.out.print("단수는 ：");
            n = stdIn.nextInt();
        } while (n <= 0);

        npira(n); // 피라미드를 나타냄
    }
}

