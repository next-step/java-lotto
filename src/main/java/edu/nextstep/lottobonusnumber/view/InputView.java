package edu.nextstep.lottobonusnumber.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = scanner.nextLine();
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(0);
            return 0;
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        String inputValue = scanner.nextLine();
        return inputValue;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String inputValue = scanner.nextLine();
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(0);
            return 0;
        }
    }
}
