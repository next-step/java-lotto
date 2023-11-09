package lotto.fixture;

import lotto.strategy.NumberStrategy;

public class FixtureNumberStrategy implements NumberStrategy {

    int number = 0;

    @Override
    public int create() {
        number += 1;
        return number;
    }
}
