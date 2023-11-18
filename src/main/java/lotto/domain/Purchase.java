package lotto.domain;

import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Purchase {

    private final Money money;
    private final List<Lotto> lottos;

    public Purchase(int money) {
        this(money, new RandomNumberStrategy());
    }

    public Purchase(int amount, NumberStrategy numberStrategy) {
        this.money = new Money(amount);
        this.lottos = numberStrategy.create(lottoCount());
    }

    public int amount() {
        return money.price();
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int lottosSize() {
        return lottos.size();
    }

    private int lottoCount() {
        return money.lottoCount();
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
