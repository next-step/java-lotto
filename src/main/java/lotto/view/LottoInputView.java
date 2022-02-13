package lotto.view;

import java.util.Scanner;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPACE = " ";
    private static final String EMPTY = "";
    private static final String COMMA = ",";
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";

    public int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public String[] inputWinningNumber() {
        System.out.println(INPUT_LAST_WEEK_WINNING_NUMBER_MESSAGE);
        final String input = SCANNER.nextLine();
        return splitWinningNumber(input);
    }

    private String[] splitWinningNumber(final String input) {
        return input.replace(SPACE, EMPTY).split(COMMA);
    }

    public int inputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

}
