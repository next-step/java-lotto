package step3.domain.lotto;

import step3.domain.money.Money;

public class LottoMachine {

    private static final Integer LOTTO_PRICE = 1000;

    private final LottoStrategy numberStrategy;

    public LottoMachine(LottoStrategy numberStrategy) {
        this.numberStrategy = numberStrategy;
    }

    public Lottos sell(Money money) {
        final int lottoCount = money.amount() / LOTTO_PRICE;

        Lottos lottos = new Lottos();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.create(numberStrategy.createNumbers()));
        }

        return lottos;
    }

}
