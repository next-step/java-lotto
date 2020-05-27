package lotto.view;

import java.util.Scanner;

public class InputView {
    static final class TEXT {
        private static final String INPUT_AMOUNT_FOR_BUY_LOTTO = "구입금액을 입력해주세요";
        private static final String INPUT_WINNING_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(TEXT.INPUT_AMOUNT_FOR_BUY_LOTTO);
        return scanner.nextInt();
    }

    public static String inputWinningNumber() {
        System.out.println(TEXT.INPUT_WINNING_LOTTO_NUMBERS);
        return scanner.nextLine();
    }
}
