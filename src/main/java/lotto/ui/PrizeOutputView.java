package lotto.ui;

import lotto.domain.rank.Rank;
import lotto.domain.rank.Ranks;
import lotto.domain.shop.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class PrizeOutputView {
    private Ranks ranks;

    public PrizeOutputView(Ranks ranks) {
        this.ranks = ranks;
    }

    protected String getIndividualStatistics(Rank rank) {
        return rank.toString() +
                "- " +
                ranks.getCount(rank) +
                "개";
    }

    public String getTotalStatistics() {
        return Arrays.stream(Rank.values())
                .filter(Rank::canGetPrize)
                .map(this::getIndividualStatistics)
                .reduce("", (previousStatistics, statistics) -> previousStatistics + statistics + "\n");
    }

    public String getTotalRateOfReturn(Money boughtMoney) {
        BigDecimal totalValue = BigDecimal.valueOf(ranks.calculateTotalPrize());
        BigDecimal boughtValue = BigDecimal.valueOf(boughtMoney.getValue());
        return "총 수익률은 " +
                totalValue.divide(boughtValue, 2, RoundingMode.HALF_UP) +
                "입니다.";
    }

    public void printPrizeStatistics(Money boughtMoneyValue) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(this.getTotalStatistics());
        System.out.println(this.getTotalRateOfReturn(boughtMoneyValue));
    }
}
