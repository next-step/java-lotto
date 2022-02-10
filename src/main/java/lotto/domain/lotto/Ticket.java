package lotto.domain.lotto;

import java.util.List;

public class Ticket {

    private final Numbers lotto;

    public Ticket(final Numbers numbers) {
        this.lotto = numbers;
    }

    public Numbers getLotto() {
        return lotto;
    }

    public int matches(final List<Number> comparison) {
        return lotto.countMatches(comparison);
    }

    public boolean hasBonus(final int bonus) {
        return lotto.hasBonus(new Number(bonus));
    }
}
