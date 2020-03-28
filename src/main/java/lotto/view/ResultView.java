package lotto.view;

import lotto.domain.Constant;
import lotto.domain.LottoGameResults;
import lotto.domain.LottoWinningLevel;

import java.util.List;

public class ResultView {
    private static final String RESULT_SUMMARY_MESSAGE = "당첨 통계";
    private static final String CARRIAGE_RETURN = "\n";
    private static final String DIVISION_LINE = "---------";
    private static final String MATCH_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String NET_PROFIT_MESSAGE =
            "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final int LOTTO_WIN_MIN = 3;
    private static final int LOTTO_WIN_MAX = 6;

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void print(LottoGameResults results) {
        List<Long> winningGames = results.getWinningGames();
        int totalGameCount = results.getTotalGameCount();

        initMessage();
        long winningPrizeSum = getWinningPrizeSum(winningGames);
        profitRate(totalGameCount, winningPrizeSum);

        System.out.println(stringBuilder.toString());
    }

    private static void initMessage() {
        stringBuilder.append(RESULT_SUMMARY_MESSAGE)
                .append(CARRIAGE_RETURN)
                .append(DIVISION_LINE)
                .append(CARRIAGE_RETURN);
    }

    private static long getWinningPrizeSum(List<Long> winningGames) {
        long winningPrizeSum = 0;
        for (int i = LOTTO_WIN_MIN; i <= LOTTO_WIN_MAX; i++) {
            long count = getMatchCount(winningGames, i);
            String message = getString(i, count);
            stringBuilder.append(message + CARRIAGE_RETURN);
            winningPrizeSum += (count * LottoWinningLevel.of(i).getWinningPrize());
        }
        return winningPrizeSum;
    }

    private static long getMatchCount(List<Long> winningGames, int index) {
        return winningGames.stream()
                .filter(matchCount -> isMatch(matchCount, index))
                .count();
    }

    private static boolean isMatch(Long matchCount, int checkPoint) {
        return matchCount == checkPoint;
    }

    private static String getString(int i, long count) {
        return String.format(
                MATCH_MESSAGE, i, LottoWinningLevel.of(i).getWinningPrize(),
                count
        );
    }

    private static void profitRate(int totalGameCount, long winningPrizeSum) {
        double totalPaidMoney = totalGameCount * Constant.DEFAULT_GAME_PRICE;
        double profitRate = winningPrizeSum / totalPaidMoney;
        stringBuilder.append(String.format(NET_PROFIT_MESSAGE, profitRate));
    }

}
