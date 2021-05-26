package com.lotto.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputDataFromConsole() {
        return scanner.nextLine();
    }
}
