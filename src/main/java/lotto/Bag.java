package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bag {
    private static final int ZERO = 0;

    private Money money;
    private final List<Lotto> lottos;

    public Bag(int money) {
        this(new Money(money), new ArrayList<>());
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

        while (lottoCount-- > ZERO) {
            this.lottos.add(new Lotto());
        }
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public LottoResult lottoResult(Lotto target) {
        return new LottoResult(this.lottos, target);
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
