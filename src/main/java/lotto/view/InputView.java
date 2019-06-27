package lotto.view;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream printStream = System.out;

    private static final String ASK_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.\n";
    private static final String ASK_WON_NORMAL_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_WON_BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static int askPurchaseAmount() {

        printStream.println(ASK_PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static int askManualCount() {

        printStream.println(ASK_MANUAL_COUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<String> askManualNumbers(int manualCount) {

        if (manualCount < 0) {
            return Collections.emptyList();
        }

        printStream.print(ASK_MANUAL_NUMBERS_MESSAGE);
        return IntStream.range(0, manualCount)
                .mapToObj(i -> scanner.next())
                .collect(Collectors.toList());
    }

    public static String askWonNormalNumbers() {

        printStream.println(ASK_WON_NORMAL_NUMBERS_MESSAGE);
        return scanner.next();
    }

    public static String askWonBonusNumbers() {

        printStream.println(ASK_WON_BONUS_NUMBERS_MESSAGE);
        return scanner.next();
    }
}
