package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsOutputView {
    private static final String PROFIT_HEADER = "총 수익률은 ";
    private static final String POSITIVE_PROFIT_FOOTER = "입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String NEGATIVE_PROFIT_FOOTER = "입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";

    public static String parseLottoPrize(LottoPrize lottoPrize) {
        Map<Rank, Long> prizeResult = lottoPrize.getResult();

        return prizeResult.keySet().stream()
                .sorted(Comparator.comparingInt(Rank::getNumberOfMatchedNumber))
                .map(rank -> rank.getDescription() + "- " + prizeResult.get(rank) + "개\n")
                .collect(Collectors.joining());
    }

    public static String parseProfit(Money money, LottoPrize lottoPrize) {
        Double profitRate = lottoPrize.calculateProfitRate(money);
        if (profitRate < 1) {
            return PROFIT_HEADER + lottoPrize.calculateProfitRate(money) + NEGATIVE_PROFIT_FOOTER;
        }
        return PROFIT_HEADER + lottoPrize.calculateProfitRate(money) + POSITIVE_PROFIT_FOOTER;
    }
}
