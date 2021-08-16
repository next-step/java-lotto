package lotto.domain;

public class LottoGame {

    private final Lotto lotto;
    private final int price;

    public LottoGame(final int price, final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        this.price = price;
        this.lotto = new Lotto(price, lottoNumberSelectPolicy);
    }

    public int size() {
        return lotto.getTicketSize();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public void checkResult(final LottoNumbers lottoNumbers) {
        lotto.checkResult(lottoNumbers);
    }

}
