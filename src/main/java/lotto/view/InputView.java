package lotto.view;

import java.util.Scanner;

public class InputView {
    private static String REQUEST_INIT_MESSAGE = "구입금액을 입력해 주세요.";
    private static String REQUEST_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int requestPurchaseAmount() {
        System.out.println(REQUEST_INIT_MESSAGE);
        return scanner.nextInt();
    }

    public static String requestLastWeekWinningNumber() {
        System.out.println(REQUEST_LAST_WEEK_WINNING_NUMBER_MESSAGE);
        return scanner.next();
    }
}
