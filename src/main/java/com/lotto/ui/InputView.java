package com.lotto.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPrice() throws IllegalArgumentException {
        return scanner.nextLine();
    }

    public static String inputWinningNumbers() throws IllegalArgumentException {
        return scanner.nextLine();
    }
}
