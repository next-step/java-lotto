package study.step3.view;

import java.util.Scanner;

public class InputView {
    private final static String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String MESSAGE_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final static Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    public static String[] inputWinNumber() {
        System.out.println(MESSAGE_WIN_NUMBER);
        scanner.nextLine();
        return scanner.nextLine().split(",");
    }
}
