import java.util.Random;
import java.util.Scanner;

public class MaxOfArray {
    // 배열 요소의 최댓값을 나타낸다.
     static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최댓값을 구한다.");
        System.out.print("사람 수 : ");
        int num = stdIn.nextInt();    // 배열의 요솟수를 입력 받음

        int[] height = new int[num]; // 요솟수가 num 인 배열 height 생성

        for (int i = 0; i < num; i++) {
            System.out.print("height[" + i + "] : ");
            height[i] = stdIn.nextInt();
        }
        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}

class MaxOfArrayRand {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최댓값을 구한다.");
        System.out.print("사람 수: ");
        int num = stdIn.nextInt();  // 배열의 요솟수를 입력 받음

        int[] height = new int[num]; // 요솟수가 num인 배열을 생성

        System.out.println("키 값은 아래와 같다.");
        for (int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90); // 요소의 값을 난수로 결정
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("최댓값은 " + MaxOfArray.maxOf(height) + "입니다.");
    }
}
class test2 {

    static long seed() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        Random ran1 = new Random(seed());
        for (int i = 0; i < 5; i++) {
            long num = ran1.nextLong();
            System.out.println(num);
        }
        System.out.println("-------------");
        Random ran2 = new Random(seed());
        for (int i = 0; i < 5; i++) {
            long num = ran2.nextLong();
            System.out.println(num);
        }
    }
}