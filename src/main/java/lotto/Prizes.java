package lotto;

import java.util.List;

public class Prizes {

    private final List<Money> prizes;

    public Prizes(List<Money> prizes) {
        this.prizes = prizes;
    }

    public Money sum() {
        return this.prizes.stream()
                .reduce(Money::sum)
                .orElseGet(() -> new Money(0));
    }
}