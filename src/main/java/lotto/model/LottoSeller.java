package lotto.model;

public class LottoSeller {
    private LottoNumbersGenerator generator;

    private static final Money LOTTO_PRICE = new Money(1000);

    public LottoSeller(LottoNumbersGenerator generator) {
        this.generator = generator;
    }

    public Lottos sell(Money money) {
        int quotient = (int) money.divide(LOTTO_PRICE);

        Lottos lottos = new Lottos();
        for (int i = 0; i < quotient; i++) {
            lottos.add(new Lotto(generator.generate()));
        }

        return lottos;
    }
}
