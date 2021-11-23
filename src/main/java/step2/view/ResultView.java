package step2.view;

import step2.domain.Lotto;
import step2.domain.Number;
import step2.domain.Price;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String COMMA = ", ";
    private static final String PURCHASE_LOTTO_RESULT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DASH_LINE = "---------";
    private static final String SHOW_WINNING_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String SHOW_BONUS_WINNING_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static final String WINNING_RESULT_REVENUE_MESSAGE = "총 수익률은 %.2f 입니다.\n";

    public static void showLottoGenerateCount(int manualLottoCount, int autoLottoCount) {
        System.out.printf(PURCHASE_LOTTO_RESULT_MESSAGE, manualLottoCount, autoLottoCount);
    }

    public static void showAllLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(LEFT_SQUARE_BRACKET + toJoiningLottoNumbers(lotto) + RIGHT_SQUARE_BRACKET);
        }
    }

    private static String toJoiningLottoNumbers(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .map(Number::getStringNumber)
                .collect(Collectors.joining(COMMA));
    }

    public static void showWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DASH_LINE);
    }

    public static void showWinningResultOfWinningType(int matchCount, int winnings, int matchResult) {
        System.out.printf(SHOW_WINNING_RESULT_MESSAGE, matchCount, winnings, matchResult);
    }

    public static void showBonusWinningResultOfWinningType(int matchCount, int winnings, int matchResult) {
        System.out.printf(SHOW_BONUS_WINNING_RESULT_MESSAGE, matchCount, winnings, matchResult);
    }

    public static void showWinningResultOfRevenue(Price price, int totalWinnings) {
        System.out.printf(WINNING_RESULT_REVENUE_MESSAGE, price.revenueOf(totalWinnings));
    }
}
