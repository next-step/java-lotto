package edu.nextstep.lottobonusnumber.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String PAYMENT = "구입금액";
    private static final String BONUS_NUMBER = "보너스 볼";

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputNumber(PAYMENT);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputNumber(BONUS_NUMBER);
    }

    private static int inputNumber(String inputName) {
        String inputValue = scanner.nextLine();
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println(inputName + "은 숫자만 입력 가능합니다.");
            System.exit(0);
            return 0;
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }


}
