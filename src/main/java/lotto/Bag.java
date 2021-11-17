package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Bag {
    private static final int ZERO = 0;

    private Money money;
    private final List<Lotto> lottos;

    public Bag(int money) {
        this(new Money(money), new ArrayList<>());
    }

    public Bag(int money, Lotto... lottos) {
        this(new Money(money), Arrays.asList(lottos));
    }

    public Bag(int money, List<Lotto> lottos) {
        this(new Money(money), lottos);
    }

    public Bag(Money money, List<Lotto> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public void buyLotto(Money unitPrice) {
        if (money.lessThan(unitPrice)) {
            throw new IllegalArgumentException("로또를 살 돈이 없습니다.");
        }

        int lottoCount = money.quotient(unitPrice);
        money = money.minus(lottoCount, unitPrice);

        while (lottoCount-- > 0) {
            this.lottos.add(new Lotto());
        }
    }

    public Map<Prize, Integer> lottoResult(Lotto target) {
        Map<Prize, Integer> result = new HashMap<>();

        for (Lotto lotto : this.lottos) {
            Prize prize = lotto.result(target);
            emptyCheckAndSetDefault(result, prize);

            result.put(prize, result.get(prize) + 1);
        }

        return result;
    }

    private void emptyCheckAndSetDefault(Map<Prize, Integer> result, Prize prize) {
        if (!result.containsKey(prize)) {
            result.put(prize, ZERO);
        }
    }

    public double yield(Lotto lotto) {
        final Map<Prize, Integer> result = this.lottoResult(lotto);

        final double totalPrize = Arrays.stream(Prize.values())
                .filter(prize -> result.containsKey(prize))
                .mapToDouble(prize -> (double) result.get(prize) * prize.money())
                .sum();

        return totalPrize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bag bag = (Bag) o;
        return Objects.equals(money, bag.money) && Objects.equals(lottos.size(), bag.lottos.size());
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lottos);
    }
}
