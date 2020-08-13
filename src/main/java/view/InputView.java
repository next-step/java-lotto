package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BUY_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputBuyPrice() {
        System.out.println(INPUT_BUY_PRICE_MESSAGE);
        return scanner.nextInt();
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return scanner.next();
    }
}
