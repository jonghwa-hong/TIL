public class IntArray {
    public static void main(String[] args) {
        int[] a = new int[5];

        a[1] = 37;  // a[1]에 37을 대입
        a[2] = 51;  // a[2]에 51을 대입

        a[4] = a[1] * 2;
        // 배열의 구성 요소는 자동으로 0으로 초기화되는 규칙이 있다.
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] : " + a[i]);
        }
    }
}

class IntArrayInit {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5}; // 배열 초기자에 의해 생성

        for(int i = 0; i < a.length; i++) {
            System.out.println("a[" + i +"] : " + a[i]);
        }

    }
}

class CloneArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = a.clone(); // b는 a의 복제를 참조

        b[3] = 0; // 한 요소에만 0을 대입

        System.out.print("a =");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.print("\nb =");
        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i]);
        }
    }
}
