package lotto.view;

import java.util.Scanner;

public class InputView {
    Scanner view = new Scanner(System.in);

    public String nextLine() {
        return view.nextLine();
    }

    public int[] nextIntArray() {
        String userInput = view.nextLine();
        String[] stringNumbers = userInput.split("\\s*,\\s*");
        int[] intArr = new int[stringNumbers.length];
        int idx = 0;
        for (String number : stringNumbers) {
            intArr[idx++] = Integer.parseInt(number);
        }
        return intArr;
    }

}
