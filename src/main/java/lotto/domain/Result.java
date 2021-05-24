package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;

import java.math.BigDecimal;

public final class Result {

    private final Lotto winningLotto;
    private BigDecimal winnings = BigDecimal.ZERO;
    private BigDecimal profitRate = BigDecimal.ZERO;

    public Result(Number... numbers) {
        winningLotto = new Lotto(numbers);
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

    private void checkRank(int count){
        if(count == 3)
            winnings = winnings.add(LottoWinnings.FOURTH);
        if(count == 4)
            winnings = winnings.add(LottoWinnings.THIRD);
        if(count == 5)
            winnings = winnings.add(LottoWinnings.SECOND);
        if(count == 6)
            winnings = winnings.add(LottoWinnings.FIRST);
    }

    public BigDecimal winnings() {
        return winnings;
    }

    private void calculateProfitRate(int purchasesCount){
        BigDecimal totalPurchaseAmount = LottoPrice.PRICE.multiply(new BigDecimal(purchasesCount));
        profitRate = winnings.divide(totalPurchaseAmount, 2);
    }

    public BigDecimal profitRate(){
        return profitRate;
    }
}
