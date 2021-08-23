package lotto.domain;

import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUM_COUNT = 6;
    static final int LOTTO_MAX_NUM = 45;
    private static final GenerateNumStrategy generateNumStrategy = new AutoGenerateStrategy(LOTTO_MAX_NUM);

    private Money money;

    LottoMachine(int money) {
        this.money = new Money(money);
    }

    LottoMachine() {
        this.money = new Money(0);
    }

    int buyableLottos() {
        return money.buyableLottos(LOTTO_PRICE);
    }

    List<Integer> generateNums(GenerateNumStrategy generateNumStrategy) {
        return generateNumStrategy.generate();
    }
}
