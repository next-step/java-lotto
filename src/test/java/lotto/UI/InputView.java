package lotto.UI;

import java.util.Scanner;

public class InputView {

    private static final String AMOUNT_QUESTION_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS__QUESTION_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void closeScanner() {
        scanner.close();
    }

    public int EnterAmount() {
        System.out.println(AMOUNT_QUESTION_MESSAGE);
        return scanner.nextInt();
    }

    public String EnterWinningNumbers() {
        System.out.println(WINNING_NUMBERS__QUESTION_MESSAGE);
        return scanner.next();
    }
}
