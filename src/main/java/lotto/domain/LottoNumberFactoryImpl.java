package lotto.domain;

public class LottoNumberFactoryImpl implements LottoNumberFactory{
    private Strategy strategy;

    public LottoNumberFactoryImpl() {
        this(new RandomStrategy());
    }

    public LottoNumberFactoryImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public LottoNumber generateNumber() {
        return new LottoNumber(strategy.generateNumber());
    }

    @Override
    public void setGenerateStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
