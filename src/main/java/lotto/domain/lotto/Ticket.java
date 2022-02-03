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

    public int matches(final List<Integer> comparison) {
        return (int) lotto.get().stream()
            .filter(comparison::contains)
            .count();
    }

    public boolean checkBonus(final int bonus) {
        return lotto.get().stream()
            .anyMatch(number -> number == bonus);
    }
}
