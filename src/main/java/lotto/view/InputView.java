package lotto.view;

import java.util.Scanner;

public final class InputView {
    private static final String AMOUNT_QUESTION_MESSAGE = "구입금액을 입력해 주세요. (1장당 1000원 입니다.)";
    private static final String WINNING_NUMBERS_QUESTION_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String askAmount() {
        System.out.println(AMOUNT_QUESTION_MESSAGE);
        return inputAnswer();
    }

    public static String askWinningLottoNumbers() {
        System.out.println(WINNING_NUMBERS_QUESTION_MESSAGE);
        return inputAnswer();
    }

    private static String inputAnswer() {
        return SCANNER.nextLine();
    }
}
