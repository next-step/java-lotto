package lotto.view;

import java.util.Scanner;

public class InputView {
    static final class TEXT {
        private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해주세요";
        private static final String INPUT_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmount() {
        System.out.println(TEXT.INPUT_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    public String inputWinningNumber() {
        System.out.println(TEXT.INPUT_WINNING_LOTTO_NUMBERS);
        return scanner.nextLine();
    }
}
