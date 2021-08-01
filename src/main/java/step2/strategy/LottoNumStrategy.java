package step2.strategy;

import step2.domain.Lotto;

public interface LottoNumStrategy {
    int makeNumber();
    Lotto makeLotto();
}
