package edu.nextstep.lottobonusnumber.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PAYMENT = "구입금액";
    private static final String BONUS_NUMBER = "보너스 볼";

    public static int inputPayment() {
        return inputNumber(PAYMENT);
    }

    public static int inputBonusNumber() {
        return inputNumber(BONUS_NUMBER);
    }

    private static int inputNumber(String valueName) {
        System.out.println(valueName + "을 입력해 주세요.");
        try {
            String inputValue = scanner.nextLine();
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println(valueName + "은 숫자만 입력 가능 합니다.");
            System.exit(0);
            return 0;
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }


}
