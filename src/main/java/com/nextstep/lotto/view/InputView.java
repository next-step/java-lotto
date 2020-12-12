package com.nextstep.lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = SCANNER.nextLine();
        return Integer.parseInt(line);
    }

    public static String inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = SCANNER.nextLine();
        System.out.println();
        return line;
    }
}
