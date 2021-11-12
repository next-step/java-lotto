package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Bag {
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
            throw new IllegalArgumentException("Not enough to buy lotto...");
        }

        int lottoCount = money.quotient(unitPrice);
        money = money.minus(lottoCount, unitPrice);

        while (lottoCount-- > 0) {
            this.lottos.add(new Lotto());
        }
    }

    public List<Integer> lottoResult(Lotto target) {
        Integer[] result = new Integer[7];
        for (int i = 0; i < 7; i++) {
            result[i] = 0;
        }

        for (Lotto lotto : this.lottos) {
            result[lotto.hitCount(target)]++;
        }

        return Arrays.asList(result);
    }

    public double yield(List<Double> prizeList, Lotto lotto) {
        final List<Integer> result = this.lottoResult(lotto);

        final double totalPrize = Stream.iterate(0, i -> i + 1)
                .limit(7)
                .mapToDouble(index -> result.get(index) * prizeList.get(index))
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
