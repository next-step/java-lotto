package lotto.domain;

import java.util.List;
import java.util.Map;

public class LottoGame {

    private final Lotto lotto;
    private final LottoWinningPolicy lottoWinningPolicy = new LottoWinningPolicy();
    private final int price;

    public LottoGame(final int price) {
        lotto = new Lotto(price);
        this.price = price;
    }

    public int getGameNum() {
        return lotto.getTicketNum();
    }

    public void setWinningNumber(final String winningNumbersString) {
        lottoWinningPolicy.setWinningNumber(winningNumbersString);
    }

    public List<Integer> getWinningNumber() {
        return lottoWinningPolicy.getWinningNumber();
    }

    public void checkResult() {
        lotto.checkResult(lottoWinningPolicy.getWinningNumber());
    }

    public void setResult() {
        lottoWinningPolicy.setResult(lotto);
    }

    public Map<LottoRank, Integer> getResult() {
        return lottoWinningPolicy.getResult();
    }

    public double getProfitRate() {
        return (double) lottoWinningPolicy.calculateWinningPrice() / price;
    }

    public Lotto getLottoGame() {
        return lotto;
    }
}
