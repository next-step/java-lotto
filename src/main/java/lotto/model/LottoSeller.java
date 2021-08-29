package lotto.model;

public class LottoSeller {
    private final LottoNumbersGenerator generator;

    private static final Money LOTTO_PRICE = new Money(1000);

    public LottoSeller(LottoNumbersGenerator generator) {
        this.generator = generator;
    }

    public Lottos sell(Money money, ManualNumbers manualNumbers) {
        int quotient = (int) money.divide(LOTTO_PRICE) - manualNumbers.size();

        Lottos lottos = new Lottos();
        for (int i = 0; i < quotient; i++) {
            lottos.add(new Lotto(generator.generate()));
        }

        lottos.add(manualNumbers);

        return lottos;
    }
}
