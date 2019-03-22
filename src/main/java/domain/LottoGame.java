package domain;

import java.util.ArrayList;
import java.util.List;

import static util.Constants.PRICE_OF_LOTTO;

public class LottoGame {

    private int money;
    private Lottos lottos;

    public LottoGame(int money) {
        assert money > PRICE_OF_LOTTO;

        this.money = money;
        this.lottos = createLottos(money);
    }

    private Lottos createLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / PRICE_OF_LOTTO; i++) {
            lottos.add(Lotto.createAuto());
        }

        return new Lottos(lottos);
    }

    public LottoResult figure(Numbers winNumbers) {
        return lottos.figure(money, winNumbers);
    }

    public List<Lotto> getLottos() {
        return this.lottos.getLottos();
    }
}
