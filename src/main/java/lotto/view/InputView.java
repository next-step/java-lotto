package lotto.view;

import java.util.Scanner;

public class InputView {

    public static final String PURCHASE_GUIDE = "구매 금액을 입력해주세요.";
    public static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmountGuide() {
        System.out.println(PURCHASE_GUIDE);
        return inputPurchaseAmount();
    }

    private int inputPurchaseAmount() {
        return scanner.nextInt();
    }

    public String inputWinnerNumber() {
        clearBuffer();
        System.out.println(INPUT_WINNING_NUMBER);
        return scanner.nextLine();
    }

    private void clearBuffer() {
        scanner.nextLine();
    }

}
