package lotto.domain.lotto;

import java.util.List;

public class Ticket {

    private final Numbers numbers;

    public Ticket(final Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public int matches(final List<Number> comparison) {
        return numbers.countMatches(comparison);
    }

    public boolean hasBonus(final int bonus) {
        return numbers.hasBonus(new Number(bonus));
    }
}
