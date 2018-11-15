package net.chandol.lotto.domain;

import net.chandol.lotto.type.LottoPrize;
import net.chandol.lotto.value.Money;

import java.util.List;

import static net.chandol.lotto.value.Money.ZERO;

public class LottoGameResult {
    private List<LottoPrize> prizes;
    private Money purchasePrice;

    public LottoGameResult(List<LottoPrize> prizes, Money purchasePrice) {
        this.prizes = prizes;
        this.purchasePrice = purchasePrice;
    }

    public Money getTotalPrize() {
        return prizes.stream()
                .map(LottoPrize::getPrize)
                .reduce(ZERO, Money::add);
    }

    public double getProfitRate() {
        return getTotalPrize().calculateProfitRate(purchasePrice);
    }

    private Integer getPrizeCount(LottoPrize lottoPrize) {
        return (int) prizes.stream().filter(l -> l == lottoPrize).count();
    }

    public String getFormattedResult(LottoPrize lottoPrize) {
        StringBuilder resultBuilder = new StringBuilder(lottoPrize.getMatchCount() + "개 일치");

        if (lottoPrize.getNeedMatch()) {
            resultBuilder.append(", 보너스 볼 일치");
        }

        resultBuilder.append(String.format(" (%d) - %d개", lottoPrize.getPrize().getValue(), getPrizeCount(lottoPrize)));
        return resultBuilder.toString();
    }
}
