package lotto.domain;

public class LottoNumberFactoryImpl implements LottoNumberFactory{
    private Strategy strategy;

    public LottoNumberFactoryImpl() {
    }

    public LottoNumberFactoryImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Number generateNumber(Integer customNumber) {
        return null;
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
