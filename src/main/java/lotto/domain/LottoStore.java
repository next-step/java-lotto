package lotto.domain;

public class LottoStore implements Store{
    @Override
    public Lottos sell(Money buyAmount) {
        return LottoGenerator.generate(buyAmount);
    }
}
