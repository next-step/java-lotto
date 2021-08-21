package app.action;

import app.domain.lotto.Lotto;
import app.strategy.LottoNumStrategy;

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

    public Lotto makeLotto() {
        return strategy.makeLotto();
    }

}
