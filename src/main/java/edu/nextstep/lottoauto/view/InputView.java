package edu.nextstep.lottoauto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String inputValue = scanner.nextLine();
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println("금액은 숫자만 입력 가능 합니다.");
            System.exit(0);
            return 0;
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

}
