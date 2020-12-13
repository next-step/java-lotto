package lotto;

import java.util.Scanner;

public class InputView {
    private static final String LOTTO_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int lottoStart() {
        System.out.println(LOTTO_START_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String winningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_MESSAGE);
        return SCANNER.nextLine();
    }
}
