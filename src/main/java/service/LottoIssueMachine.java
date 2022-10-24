package service;

import domain.Lottos;
import domain.Money;

public class LottoIssueMachine {

    private static final int LOTTO_PRICE = 1000;

    private final RandomLottoGenerator randomLottoGenerator;

    public LottoIssueMachine(RandomLottoGenerator randomLottoGenerator) {
        this.randomLottoGenerator = randomLottoGenerator;
    }

    public Lottos purchaseLotto(Money money) {

        int purchasedCount = money.getMoney() / LOTTO_PRICE;

        Lottos lottos = new Lottos();
        lottos.buyRandomLottos(randomLottoGenerator, purchasedCount);
        return lottos;
    }

}
