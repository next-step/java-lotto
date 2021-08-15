package lotto.domain;

public class LottoGame {

    private final Lotto lotto;
    private final int price;

    public LottoGame(final int price, final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        this.price = price;
        lotto = buyLotto(lottoNumberSelectPolicy);
    }

    public int getLottoTicketSize() {
        return lotto.getTicketSize();
    }

    public Lotto getLotto() {
        return lotto;
    }

    private Lotto buyLotto(final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        return new Lotto(price, lottoNumberSelectPolicy);
    }

    public void checkResult(final LottoNumbers lottoNumbers) {
        lotto.checkResult(lottoNumbers);
    }

}
