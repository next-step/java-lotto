package edu.nextstep.lotto.step2.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_PURCHASE_AMOUNT = "구입 금액을 입력해주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요.";
    private final Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmount() {
        System.out.println(QUESTION_PURCHASE_AMOUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public String getWinningNumber() {
        System.out.println(QUESTION_WINNING_NUMBERS);
        return scanner.nextLine();
    }
}
