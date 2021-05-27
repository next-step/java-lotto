package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Result {

    private final Lotto winningLotto;
    private BigDecimal winnings = BigDecimal.ZERO;
    private BigDecimal profitRate = BigDecimal.ZERO;
    private Rank rank = new Rank();

    public Result(Lotto lotto) {
        winningLotto = lotto;
    }

    public void confirm(LottoList lottoList, LottoPrice lottoPrice) {
        rank = lottoList.compareWith(winningLotto);
        calcWinnings();
        calculateProfitRate(lottoList.size(), lottoPrice);
    }

    private void calcWinnings() {
        winnings = winnings.add(LottoWinnings.FOURTH.multiply(new BigDecimal(rank.fourth())));
        winnings = winnings.add(LottoWinnings.THIRD.multiply(new BigDecimal(rank.third())));
        winnings = winnings.add(LottoWinnings.SECOND.multiply(new BigDecimal(rank.second())));
        winnings = winnings.add(LottoWinnings.FIRST.multiply(new BigDecimal(rank.first())));
    }

    public BigDecimal winnings() {
        return winnings;
    }

    private void calculateProfitRate(int purchasesCount, LottoPrice lottoPrice) {
        BigDecimal totalPurchaseAmount = lottoPrice.multiply(new BigDecimal(purchasesCount));
        profitRate = winnings.divide(totalPurchaseAmount, 2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal profitRate() {
        return profitRate;
    }

    public Rank rank() {
        return rank;
    }
}
