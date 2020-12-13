package com.nextstep.lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseInt(SCANNER.nextLine());
    }

    public static String inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = parseInt(SCANNER.nextLine());
        System.out.println();
        return bonusNumber;
    }

    private static int parseInt(String line) {
        return Integer.parseInt(line);
    }
}
