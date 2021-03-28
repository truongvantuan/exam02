import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class readInputAndSort {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = readNumbers();

        int[] intArray = listToArray(integerList);

        Arrays.sort(intArray);

        System.out.println(Arrays.toString(intArray));
    }

    public static ArrayList<Integer> readNumbers() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> integerList = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("x") || input.equalsIgnoreCase("q")) {
                break;
            }

            if (!isNumeric(input)) {
                continue;
            }

            int number = Integer.parseInt(input);
            integerList.add(number);
        }
        return integerList;
    }

    public static int[] listToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        int index = 0;
        for (int i : list) {
            array[index] = i;
            index++;
        }
        return array;
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
