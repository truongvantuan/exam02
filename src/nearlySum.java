import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class nearlySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap vao so phan tu N: ");
        int N = scanner.nextInt();

        int[] array = randomArrayInRange(N, -10, 10);

        System.out.println(Arrays.toString(array));

        System.out.print("Nhap vao X trong khoang -10->10:");
        int X = scanner.nextInt();

        HashMap<Integer, Integer[]> intMap = arrayToHashMap(array, X);

        ArrayList<Integer> sumList = new ArrayList<>(intMap.keySet());

        Collections.sort(sumList);

        for (int i = 0; i < sumList.size(); i++) {
            int key = sumList.get(i);
            System.out.println("Cap so: " + Arrays.toString(intMap.get(key)));

            if (key != sumList.get(i + 1)) {
                break;
            }
        }
    }

    /**
     * Hàm trả về HashMap có value là mảng 2 số từ int[] array truyền vào, key là
     * tổng value trừ cho X truyền vào
     * 
     * @param array
     * @param X
     * @return
     */
    public static HashMap<Integer, Integer[]> arrayToHashMap(int[] array, int X) {
        HashMap<Integer, Integer[]> intMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int distance = Math.abs(array[i] + array[j] - X);
                Integer[] arraysIntegers = { array[i], array[j] };
                intMap.put(distance, arraysIntegers);
            }
        }
        return intMap;
    }

    /**
     * Hàm sinh ra mảng các số nguyên ngẫu nhiên từ a đến b.
     * 
     * @param N Số lượng phần tử trong mảng
     * @param a giới hạn dưới
     * @param b giới hạn trên
     * @return
     */
    public static int[] randomArrayInRange(int N, int a, int b) {
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (a + Math.random() * (b - a + 1));
        }
        return array;
    }
}