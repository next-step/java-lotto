package lotto.view;

import java.util.Scanner;

public class InputView {

    public static String question(String message) {
        System.out.println(message);
        return inputValue();
    }

    public static String inputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
