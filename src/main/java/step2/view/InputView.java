package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static int inputPurchasePrice() {
        return sc.nextInt();
    }

    public static List<Integer> inputWinNumber() {
        List<Integer> numbers = new ArrayList<>();

        sc.nextLine();
        String[] winNumbers = sc.nextLine().split(", ");

        for (int i = 0; i < winNumbers.length; i++) {
            numbers.add(Integer.parseInt(winNumbers[i]));
        }
        return numbers;
    }
}
