package lotto_step2.model;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize match(Lotto lastWeekLotto) {
        int matchCount = Math.toIntExact(lastWeekLotto.getNumbers().stream()
                .filter(number -> this.getNumbers().contains(number))
                .count());

        Prize prize = new Prize(PrizeMachine.matchPrize(matchCount));
        return prize;
    }
}
