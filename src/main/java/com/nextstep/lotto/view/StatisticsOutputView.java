package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoPrize;
import com.nextstep.lotto.domain.Money;
import com.nextstep.lotto.domain.Rank;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsOutputView {
    private static final String PROFIT_HEADER = "총 수익률은 ";
    private static final String POSITIVE_PROFIT_FOOTER = "입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String NEGATIVE_PROFIT_FOOTER = "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String LOTTO_PRIZE_SEPARATOR = "- ";
    private static final String PRIZE_UNIT = "개\n";

    public static String parseLottoPrize(LottoPrize lottoPrize) {
        Map<Rank, Long> prizeResult = lottoPrize.getResult();

        return prizeResult.keySet().stream()
                .map(rank -> parseRankDescription(rank) + LOTTO_PRIZE_SEPARATOR + prizeResult.get(rank) + PRIZE_UNIT)
                .collect(Collectors.joining());
    }

    public static String parseRankDescription(Rank rank) {
        String normalRankHeader = "개 일치 (";
        String normalRankFooter = "원)";

        if (rank == Rank.SECOND) {
            return parseSecondRankDescription();
        }

        return rank.getNumberOfMatchedNumber() +
                normalRankHeader +
                rank.getMoneyValue() +
                normalRankFooter;
    }

    public static String parseSecondRankDescription() {
        String secondRankHeader = "개 일치, 보너스 볼 일치(";
        String secondRankFooter = "원)";

        return Rank.SECOND.getNumberOfMatchedNumber() +
                secondRankHeader +
                Rank.SECOND.getMoneyValue() +
                secondRankFooter;
    }

    public static String parseProfit(Money money, LottoPrize lottoPrize) {
        Double profitRate = lottoPrize.calculateProfitRate(money);
        if (profitRate < 1) {
            return PROFIT_HEADER + lottoPrize.calculateProfitRate(money) + NEGATIVE_PROFIT_FOOTER;
        }
        return PROFIT_HEADER + lottoPrize.calculateProfitRate(money) + POSITIVE_PROFIT_FOOTER;
    }
}
