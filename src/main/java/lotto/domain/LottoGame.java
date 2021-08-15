package lotto.domain;

import java.util.Map;

public class LottoGame {

    private final Lotto lotto;
    private final LottoResult lottoWinningPolicy = new LottoResult();
    private final int price;

    public LottoGame(final int price, LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        lotto = new Lotto(price, lottoNumberSelectPolicy);
        this.price = price;
    }

    public int getGameNum() {
        return lotto.getTicketNum();
    }

    public void checkResult(LottoNumbers lottoNumbers) {
        lotto.checkResult(lottoNumbers);
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
