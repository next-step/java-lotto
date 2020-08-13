package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_BUY_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputBuyPrice() {
        System.out.println(INPUT_BUY_PRICE_MESSAGE);
        return scanner.nextInt();
    }
}
