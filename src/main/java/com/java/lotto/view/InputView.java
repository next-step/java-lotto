package com.java.lotto.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner;

    public static Integer purchaseAmount() {
        return intScanner("구입금액을 입력해 주세요.");
    }

    public static String winningNumber() {
        return stringScanner("지난 주 당첨 번호를 입력해 주세요.");
    }

    private static Integer intScanner(String message) {
        System.out.println(message);
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static String stringScanner(String message) {
        System.out.println(message);
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
