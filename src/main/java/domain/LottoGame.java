package domain;

import java.util.List;

import static util.Constants.PRICE_OF_LOTTO;

public class LottoGame {
    private int money;
    private Lottos lottos;

    public LottoGame(int money) {
        assert money > PRICE_OF_LOTTO;

        this.money = money;
        this.lottos = Lottos.createLottos(money);
    }

    public LottoResult figure(WinningLotto winningLotto) {
        return lottos.figure(money, winningLotto);
    }

    public List<Lotto> getLottos() {
        return this.lottos.getLottos();
    }
}
