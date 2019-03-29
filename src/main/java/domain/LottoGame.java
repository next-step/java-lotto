package domain;

import java.util.List;

import static util.Constants.PRICE_OF_LOTTO;

public class LottoGame {
    private Money money;
    private Lottos lottos;

    public LottoGame(int money) {
        assert money > PRICE_OF_LOTTO;

        this.money = Money.of(money);
        this.lottos = Lottos.createLottos(money);
    }

    public LottoResult figure(WinningLotto winningLotto) {
        return new LottoResult(money, lottos.figure(winningLotto));
    }

    public List<Lotto> getLottos() {
        return this.lottos.getLottos();
    }
}
