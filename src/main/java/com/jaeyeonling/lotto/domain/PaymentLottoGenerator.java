package com.jaeyeonling.lotto.domain;

abstract class PaymentLottoGenerator implements LottoGenerator {

    protected abstract Lotto generate();

    @Override
    public Lotto generate(final Money money) {
        final Lotto lotto = generate();
        money.buy(lotto);

        return lotto;
    }
}
