package com.java.lotto.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner;

    public static Integer purchaseAmount() {
        return intScanner("구입금액을 입력해 주세요.");
    }

    private static Integer intScanner(String message) {
        System.out.println(message);
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
