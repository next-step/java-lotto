package lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int enterLottoAmount() {
        System.out.println(Message.ENTER_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    public String enterWinningNumbers() {
        System.out.println(Message.ENTER_WINNING_NUMBERS);
        return scanner.nextLine();
    }
}
