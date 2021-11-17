package step2.view;

import step2.domain.Number;
import step2.domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String COMMA = ", ";
    private static final String PURCHASE_LOTTO_RESULT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DASH_LINE = "---------";
    private static final String SHOW_WINNING_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String WINNING_RESULT_REVENUE_MESSAGE = "총 수익률은 %.2f 입니다.\n";

    public static void showLottoGenerateCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + PURCHASE_LOTTO_RESULT_MESSAGE);
    }

    public static void showAllLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String numbers = lotto.getLottoNumbers().stream()
                    .map(Number::getStringNumber)
                    .collect(Collectors.joining(COMMA));
            System.out.println(LEFT_SQUARE_BRACKET + numbers + RIGHT_SQUARE_BRACKET);
        }
    }

    public static void showWinningStatistics(int price, WinningResult winningResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DASH_LINE);
        showWinningResult(winningResult);
        showWinningResultRevenue(price, winningResult);
    }

    private static void showWinningResult(WinningResult winningResult) {
        Map<WinningType, Integer> winningResultMap = winningResult.getWinningResult();
        for (WinningType type : winningResultMap.keySet()) {
            System.out.printf(SHOW_WINNING_RESULT_MESSAGE,
                    type.getMatchCount(), type.getWinnings(), winningResultMap.get(type));
        }
    }

    private static void showWinningResultRevenue(int price, WinningResult winningResult) {
        System.out.printf(WINNING_RESULT_REVENUE_MESSAGE, (float) winningResult.totalWinnings() / price);
    }
}
