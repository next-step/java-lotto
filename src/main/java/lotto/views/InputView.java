package lotto.views;

import java.util.Scanner;

public class InputView {
    public final static String INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    public final static String WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    private String getValue(String description) {
        System.out.println(description);
        return scanner.nextLine();
    }

    public String getInputAmount() {
        return getValue(INPUT_AMOUNT);
    }

    public String getWinningNumbers() {
        return getValue(WINNING_NUMBERS);
    }

}
