package service;

import domain.Lottos;
import domain.Money;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos purchaseLotto(Money money) {

        int purchasedCount = money.getMoney() / LOTTO_PRICE;
        Lottos lottos = new Lottos();
        for (int i = 0; i < purchasedCount; i++) {
            lottos.addLotto(lottoGenerator.createRandomLotto());
        }
        return lottos;
    }

}
