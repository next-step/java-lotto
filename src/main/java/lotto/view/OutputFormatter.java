package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputFormatter {

    private static final String STATISTICS_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String LOSS_NOTICE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final double BREAK_EVEN_RATE = 1.0;

    private OutputFormatter() {
    }

    public static String formatPurchaseCount(int count) {
        return count + "개를 구매했습니다.";
    }

    public static String formatLotto(Lotto lotto) {
        return lotto.getNumbers().toString();
    }

    public static List<String> formatStatistics(LottoResult result) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.comparingInt(Rank::getMatchCount))
                .map(rank -> String.format(STATISTICS_FORMAT,
                        rank.getMatchCount(), rank.getPrize(), result.getCount(rank)))
                .toList();
    }

    public static String formatProfitRate(double profitRate) {
        String message = String.format(PROFIT_RATE_FORMAT, profitRate);
        if (profitRate < BREAK_EVEN_RATE) {
            return message + LOSS_NOTICE;
        }
        return message;
    }
}
