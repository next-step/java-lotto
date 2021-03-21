package lotto.step1.view;

import lotto.step1.model.Constants;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.println(Constants.enterString);
        return scanner.next();
    }

}
