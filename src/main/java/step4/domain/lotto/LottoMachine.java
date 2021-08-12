package step4.domain.lotto;

import step4.domain.money.Money;

public class LottoMachine {

    public static final Integer LOTTO_PRICE = 1000;

    public static Lottos sell(Money money) {
        return sell(money, new RandomStrategy());
    }

    public static Lottos sell(Money money, LottoStrategy lottoStrategy) {
        final int lottoCount = money.amount() / LOTTO_PRICE;

        Lottos lottos = new Lottos();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.create(lottoStrategy.createNumbers()));
        }

        return lottos;
    }


}
