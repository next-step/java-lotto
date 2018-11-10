package net.chandol.lotto.domain;

import java.util.List;

public class LottoGameResult {
    private List<LottoPrize> prizes;
    private Integer buyPrice;

    public LottoGameResult(List<LottoPrize> prizes, Integer buyPrice) {
        this.prizes = prizes;
        this.buyPrice = buyPrice;
    }

    public Integer getTotalPrize() {
        return prizes.stream()
                .mapToInt(LottoPrize::getPrize)
                .sum();
    }

    public Double getProfitRate() {
        return getTotalPrize() * 1d / buyPrice;
    }

    private Integer getPrizeCount(LottoPrize lottoPrize) {
        return (int) prizes.stream().filter(l -> l == lottoPrize).count();
    }

    public String getFormattedResult(LottoPrize lottoPrize) {
        Integer prizeCount = getPrizeCount(lottoPrize);
        return String.format("%d개 일치 (%d) - %d개", lottoPrize.getMatchCount(), lottoPrize.getPrize(), prizeCount);
    }
}
