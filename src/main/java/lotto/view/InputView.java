package lotto.view;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {
    private static String REQUEST_INIT_MESSAGE = "구입금액을 입력해 주세요.";
    private static String REQUEST_MANUAL_ROUND_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static String REQUEST_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static String REQUEST_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static int requestPurchaseAmount() {
        System.out.println(REQUEST_INIT_MESSAGE);
        return scanner.nextInt();
    }

    public static int requestManualRound() {
        System.out.println();
        System.out.println(REQUEST_MANUAL_ROUND_MESSAGE);
        return scanner.nextInt();
    }

    public static String[] requestManualNumbers(int manualRound) {
        if (manualRound == 0) {
            return new String[0];
        }

        System.out.println();
        System.out.println(REQUEST_MANUAL_NUMBERS_MESSAGE);
        return IntStream.range(0, manualRound)
                .mapToObj(m -> scanner.next())
                .toArray(String[]::new);
    }

    public static String requestLastWeekWinningNumber() {
        System.out.println();
        System.out.println(REQUEST_LAST_WEEK_WINNING_NUMBER_MESSAGE);
        return scanner.next();
    }

    public static String requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
        return scanner.next();
    }
}
