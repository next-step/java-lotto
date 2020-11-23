package step2.view;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static int inputPurchasePrice() {
        return sc.nextInt();
    }

    public static int[] inputWinNumber() {
        sc.nextLine();
        String[] winNumbers = sc.nextLine().split(", ");
        int[] parseWinNumbers = new int[winNumbers.length];
        for (int i = 0; i < winNumbers.length; i++) {
            parseWinNumbers[i] = Integer.parseInt(winNumbers[i]);
        }
        return parseWinNumbers;
    }
}
