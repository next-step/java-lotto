package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.LottoPrice;
import lotto.domain.entity.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Result {

    private final Lotto winningLotto;
    private final Number bonusNumber;
    private BigDecimal winnings = BigDecimal.ZERO;
    private BigDecimal profitRate = BigDecimal.ZERO;
    private final RankCounter rankCounter = new RankCounter();

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
        rankCounter.counting(lottoList, winningLotto, bonusNumber);
        calculateWinningMoney();
        calculateProfitRate(lottoList.size(), lottoPrice);
    }

    private void calculateWinningMoney() {
        rankCounter.entryForEach((rank, integer) -> {
            winnings = winnings.add(rank.winningMoney());
        });
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
