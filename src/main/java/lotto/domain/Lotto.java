package lotto.domain;

import java.util.List;
import java.util.Map;

public class Lotto {

    private final LottoGame lottoGame;
    private final LottoWinningPolicy lottoWinningPolicy = new LottoWinningPolicy();
    private final int price;

    public Lotto(final int price) {
        lottoGame = new LottoGame(price);
        this.price = price;
    }

    public int getGameNum() {
        return lottoGame.getTicketNum();
    }

    public void setWinningNumber(final String winningNumbersString) {
        lottoWinningPolicy.setWinningNumber(winningNumbersString);
    }

    public List<Integer> getWinningNumber() {
        return lottoWinningPolicy.getWinningNumber();
    }

    public void checkResult() {
        lottoGame.checkResult(lottoWinningPolicy.getWinningNumber());
    }

    public void setResult() {
        lottoWinningPolicy.setResult(lottoGame);
    }

    public Map<LottoRank, Integer> getResult() {
        return lottoWinningPolicy.getResult();
    }

    public double getProfitRate() {
        return (double) lottoWinningPolicy.calculateWinningPrice() / price;
    }

    public LottoGame getLottoGame() {
        return lottoGame;
    }
}
