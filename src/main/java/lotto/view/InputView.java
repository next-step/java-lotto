package lotto.view;

import lotto.domain.purchase.Amount;
import utils.Splitter;
import utils.StringUtils;

import java.util.Optional;
import java.util.Scanner;

import static lotto.view.MyPrinter.lineChange;
import static lotto.view.MyPrinter.printLine;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static int purchasePrice() {
        printLine(Announcements.PURCHASE_PRICE);
        return nextIntAndRemoveLineChange();
    }

    public static int manualAmount() {
        printLine(Announcements.PURCHASE_MANUAL_COUNT);
        return nextIntAndRemoveLineChange();
    }

    public static Optional<String[][]> manualNumbers(Amount amount) {
        if (amount.isZero()) {
            return Optional.empty();
        }
        printLine(Announcements.PURCHASE_MANUAL_NUMBERS);

        Optional<String[][]> values = Optional.of(amount.range()
                .mapToObj(i -> lottoNumbers())
                .toArray(String[][]::new));

        lineChange();

        return values;
    }

    public static String[] lastWeekWinningNumbers() {
        printLine(Announcements.LAST_WEEK_WINNING_NUMBERS);
        return lottoNumbers();
    }

    private static String[] lottoNumbers() {
        String numbers = SCANNER.nextLine();
        return Splitter.byComma(StringUtils.removeSpace(numbers));
    }

    public static int bonusBallNumber() {
        printLine(Announcements.BONUS_BALL_NUMBER);
        return nextIntAndRemoveLineChange();
    }

    private static int nextIntAndRemoveLineChange() {
        final int input = SCANNER.nextInt();
        SCANNER.nextLine();
        lineChange();
        return input;
    }

    private abstract static class Announcements {
        static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
        static final String PURCHASE_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
        static final String PURCHASE_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
        static final String LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
        static final String BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
    }
}
