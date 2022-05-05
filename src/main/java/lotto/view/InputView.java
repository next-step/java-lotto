package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String START_MESSAGE = "구매금액을 입력해주세요.";
    private static final String WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println(START_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputLastWeekWinningNumber() {
        System.out.println(WINNING_LOTTO_MESSAGE);
        return scanner.nextLine();
    }
}
