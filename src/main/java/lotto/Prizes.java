package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Prizes {

    private final Set<Money> prizes;

    public Prizes(List<Money> prizes) {
        this(new HashSet<>(prizes));
    }

    public Prizes(Set<Money> prizes) {
        this.prizes = prizes;
    }

    public Money sum() {
        return this.prizes.stream()
                .reduce(Money::sum)
                .orElseGet(() -> new Money(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prizes)) return false;
        Prizes prizes1 = (Prizes) o;
        return Objects.equals(prizes, prizes1.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}