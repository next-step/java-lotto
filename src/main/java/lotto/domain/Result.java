package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Result {

    private final Lotto winningLotto;
    private BigDecimal winnings = BigDecimal.ZERO;
    private BigDecimal profitRate = BigDecimal.ZERO;
    private final Rank rank = new Rank();

    public Result(Lotto lotto) {
        winningLotto = lotto;
    }

    public void confirm(LottoList lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            compareWith(lottoList.get(i), winningLotto);
        }
        calculateProfitRate(lottoList.size());
    }

    private void compareWith(Lotto winningLottoNumber, Lotto buyLottoNumber) {
        int count = 0;
        for (int i = 0; i < winningLottoNumber.size(); i++) {
            count = winningLottoNumber.contains(buyLottoNumber.get(i)) ? count + 1 : count;
        }
        checkRank(count);
    }

    private void checkRank(int count) {
        if (count == 3) {
            rank.addFourth();
            winnings = winnings.add(LottoWinnings.FOURTH);
        }
        if (count == 4) {
            rank.addThird();
            winnings = winnings.add(LottoWinnings.THIRD);
        }
        if (count == 5) {
            rank.addSecond();
            winnings = winnings.add(LottoWinnings.SECOND);
        }
        if (count == 6) {
            rank.addFirst();
            winnings = winnings.add(LottoWinnings.FIRST);
        }
    }

    public BigDecimal winnings() {
        return winnings;
    }

    private void calculateProfitRate(int purchasesCount) {
        BigDecimal totalPurchaseAmount = LottoPrice.PRICE.multiply(new BigDecimal(purchasesCount));
        profitRate = winnings.divide(totalPurchaseAmount, 2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal profitRate() {
        return profitRate;
    }

    public Rank rank() {
        return rank;
    }
}
