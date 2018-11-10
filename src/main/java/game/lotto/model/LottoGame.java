package game.lotto.model;

import java.util.List;

public class LottoGame {

    private Amount amount;
    private LottoRegistry lottoRegistry;

    public LottoGame(Money money) {
        this.amount = new Amount(money);
        createLottoRegistry();
    }

    private void createLottoRegistry() {
        List<Lotto> lottos = LottoFactory.createLottos(amount);
        this.lottoRegistry = new LottoRegistry(lottos);
    }

    public Amount getAmount() {
        return new Amount(amount);
    }

    public List<Lotto> getLottos() {
        return this.lottoRegistry.getLottos();
    }

}
