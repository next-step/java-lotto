package step2.domain;

import step2.strategy.LottoNumStrategy;

import java.util.List;

public class LottoMachine {

    private LottoNumStrategy strategy;

    private LottoMachine() {
    }

    private LottoMachine(LottoNumStrategy strategy) {
        this.strategy = strategy;
    }

    public static LottoMachine create() {
        return new LottoMachine();
    }

    public static LottoMachine of(LottoNumStrategy strategy) {
        return new LottoMachine(strategy);
    }

    public List<Integer> makeLotto() {
        return strategy.makeLotto().getNumbers();
    }

}
