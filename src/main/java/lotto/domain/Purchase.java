package lotto.domain;

import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;

import java.util.List;
import java.util.stream.Collectors;

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

    public int lottosSize() {
        return lottos.size();
    }

    private int lottoCount() {
        return amount / LOTTO_AMOUNT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottoCount());
        sb.append("개를 구매했습니다.\n");
        sb.append(toStringLottos());

        return sb.toString();
    }

    private String toStringLottos() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
