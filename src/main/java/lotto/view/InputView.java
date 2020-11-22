package lotto.view;

import lotto.common.Message;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int enterLottoAmount() {
        System.out.println(Message.ENTER_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    public static String enterWinningNumbers() {
        System.out.println(Message.ENTER_WINNING_NUMBERS);
        scanner.nextLine();
        return scanner.nextLine();
    }
}
