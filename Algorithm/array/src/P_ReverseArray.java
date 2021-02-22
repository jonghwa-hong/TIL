import java.util.Scanner;

class P1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("배열읠 요소: ");
        int num = scanner.nextInt();
        int[] nums = new int[num];
        System.out.println("배열의 요소를 입력해주세요. ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        num -= 1;
        for (int i = 0; i < nums.length / 2; i++, num--) {
            System.out.println("nums[" + i + "] 와 nums[" + num + "]을 교환합니다.");
            int temp = nums[i];
            nums[i] = nums[num];
            nums[num] = temp;
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println("");
        }
    }
}
/**
 * P1 리펙토링
 * */
class ReverseArrayEx_02_02 {
    // 배열의 요소 a[idx1]와 a[idx2]를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 배열 a의 요소 값을 나타냄
    static void print(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // 배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        print(a);
        for (int i = 0; i < a.length / 2; i++) {
            System.out.println("a[" + i + "]와 a[" + (a.length - i - 1) + "]를 교환합니다.");
            swap(a, i, a.length - i - 1);
            print(a);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수는 ：");
        int num = stdIn.nextInt(); // 요솟수

        int[] x = new int[num]; // 요솟수 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        reverse(x); // 배열 a의 요소를 역순으로 정렬

        System.out.println("역순 정렬을 마쳤습니다.");
//		for (int i = 0; i < num; i++)
//			System.out.println("x[" + i + "] = " + x[i]);
    }
}

class P2 {
    static int sumOf(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수는 ：");
        int num = stdIn.nextInt(); // 요솟수

        int[] x = new int[num]; // 요솟수 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
        System.out.println("위와 같은 배열의 합은 " + sumOf(x) + "입니다.");

    }
}
