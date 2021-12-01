package edu.nextstep.camp.lotto.domain;

public class Store {
    public static final int GAME_PRICE = 1000;

    private Store() {}

    public static Lottos purchase(int budget, LottoGenerator generator) {
        if (budget < GAME_PRICE) {
            throw new IllegalArgumentException("invalid input: budget must be at least 1000, but " + budget);
        }

        if (budget % GAME_PRICE != 0) {
            throw new IllegalArgumentException("invalid input: budget must be multiple of 1000, but " + budget);
        }

        return generator.generate(budget / GAME_PRICE);
    }
}
