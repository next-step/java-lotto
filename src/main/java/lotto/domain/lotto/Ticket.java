package lotto.domain.lotto;

import java.util.List;

public class Ticket {

    private final Numbers lotto;

    public Ticket(Numbers numbers) {
        this.lotto = numbers;
    }

    public Numbers getLotto() {
        return lotto;
    }

    public int matches(List<Integer> comparison) {
        return (int) lotto.get().stream()
            .filter(comparison::contains)
            .count();
    }

    public boolean checkBonus(int bonus) {
        return lotto.get().stream()
            .anyMatch(number -> number == bonus);
    }
}
