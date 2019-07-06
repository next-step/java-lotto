package com.java.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    static Scanner scanner;

    public static Integer purchaseAmount() {
        return intScanner("구입금액을 입력해 주세요.");
    }

    public static Integer countOfManualLotto() {
        System.out.println();
        return intScanner("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static List<String> inputOfManualLotto(int count) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottoNumbers.add(stringScannerNotMessage());
        }
        System.out.println();
        return manualLottoNumbers;
    }

    public static String winningNumbers() {
        return stringScanner("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static Integer bonusNumber() {
        return intScanner("보너스 볼을 입력해 주세요.");
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

    private static String stringScannerNotMessage() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
