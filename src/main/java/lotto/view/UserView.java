package lotto.view;

import java.io.PrintStream;
import java.util.Scanner;

public class UserView {
    Scanner inputView = new Scanner(System.in);
    PrintStream outputView = new PrintStream(System.out);

    public String nextLine() {
        return inputView.nextLine();
    }


    public int[] nextIntArray() {
        String userInput = inputView.nextLine();
        String[] stringNumbers = userInput.split("\\s*,\\s*");
        int[] intArr = new int[stringNumbers.length];
        int idx = 0;
        for (String number : stringNumbers) {
            intArr[idx++] = Integer.parseInt(number);
        }
        return intArr;
    }

    public void enter() {
        outputView.println("");
    }

    public void println(String message) {
        outputView.println(message);
    }

    public void println(Object obj) {
        outputView.println(obj);
    }

    public void print(String message) {
        outputView.print(message);
    }
}
