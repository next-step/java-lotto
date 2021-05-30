package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.LottoPrice;
import lotto.domain.entity.Number;
import lotto.domain.entity.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public final class Result {

    private final Lotto winningLotto;
    private final Number bonusNumber;
    private BigDecimal winnings = BigDecimal.ZERO;
    private BigDecimal profitRate = BigDecimal.ZERO;
    private RankCounter rankCounter = new RankCounter();

    public Result(Lotto lotto, Number bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, Number bonusNumber) {
        if (lotto.isNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호들과 같을 수 없습니다.");
        }
    }

    public void confirm(LottoList lottoList, LottoPrice lottoPrice) {
        rankCounter = lottoList.compareWith(winningLotto, bonusNumber);
        calculateWinningMoney();
        calculateProfitRate(lottoList.size(), lottoPrice);
    }

    private void calculateWinningMoney() {
        Map<Rank, Integer> counter = rankCounter.counter();
        for (Rank rank : counter.keySet()) {
            winnings = winnings.add(rank.winningMoney().multiply(new BigDecimal(counter.get(rank))));
        }
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

    public RankCounter rank() {
        return rankCounter;
    }
}
