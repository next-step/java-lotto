package lotto.view;

import lotto.exception.NotSupportInstanceException;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String MESSAGE_LAST_WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new NotSupportInstanceException();
    }

    public static String purchaseAmountView() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return scanner.nextLine();
    }

    public static String lastWinningLottoNumberView() {
        System.out.println(MESSAGE_LAST_WINNING_LOTTO_NUMBER);
        return scanner.nextLine();
    }
}
