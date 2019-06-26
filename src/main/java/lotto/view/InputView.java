package lotto.view;

import java.util.Scanner;

public class InputView {

    static public int promptInt(String message) {
        System.out.println(message);
        return getScanner().nextInt();
    }

    static public String promptString(String message) {
        System.out.println(message);
        return getScanner().nextLine();
    }

    static private Scanner getScanner() {
        return new Scanner(System.in);
    }
}