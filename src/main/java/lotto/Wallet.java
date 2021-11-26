package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wallet {
    private final Money money;
    private final List<Lotto> lottos;

    /*
        CONSTRUCTOR
     */
    public Wallet(int money) {
        this(new Money(money), new ArrayList<>());
    }

    public Wallet(int money, List<Lotto> lottos) {
        this(new Money(money), lottos);
    }

    public Wallet(Money money, List<Lotto> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(money, wallet.money) && lottos.size() == lottos.stream().filter(wallet.lottos::contains).count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lottos);
    }
}
