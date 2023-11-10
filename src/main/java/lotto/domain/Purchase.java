package lotto.domain;

import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;

import java.util.List;

import static lotto.validate.InputValidation.inputValidate;

public class Purchase {

    private static final int LOTTO_AMOUNT = 1000;
    private final int amount;
    private final List<Lotto> lottos;

    public Purchase(int amount) {
        this(amount, new RandomNumberStrategy());
    }

    public Purchase(int amount, NumberStrategy numberStrategy) {
        inputValidate(amount);
        this.amount = amount;
        this.lottos = numberStrategy.create(lottoCount());
    }

    public int amount() {
        return amount;
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    private int lottoCount() {
        return amount / LOTTO_AMOUNT;
    }

    @Override
    public String toString() {
        return String.format("%d개를 구매했습니다.", lottoCount());
    }
}
