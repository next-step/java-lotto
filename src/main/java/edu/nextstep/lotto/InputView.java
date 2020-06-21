package edu.nextstep.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        int input = scanner.nextInt();
        if (input < 0) {
            throw new IllegalArgumentException("illegal input data");
        }
        ResultView.lottoCount(input);

        return input;
    }

    public static String[] winNumber() {
        String input = scanner.nextLine();
        return input.split(", ");
    }
}
