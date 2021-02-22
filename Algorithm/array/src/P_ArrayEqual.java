import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 b의 모든 요소를 배열 a에 복사함
 * */
class P3 {
    static void copy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++) {
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a의 요솟수: ");
        int numLength = scanner.nextInt();
        int[] a = new int[numLength];
        for (int i = 0; i < numLength; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = scanner.nextInt();
        }

        System.out.print("b의 요솟수: ");
        int numLength2 = scanner.nextInt();
        int[] b = new int[numLength2];
        for (int i = 0; i < numLength2; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = scanner.nextInt();
        }

        copy(a, b);

        for(int i = 0; i < numLength; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }

    }
}
