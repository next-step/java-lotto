package lotto.model;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Result match(Lotto winningLotto, int bonus, Lotto myLotto) {
        int count = safeLongToInt(winningLotto.getNumbers().stream()
                .filter(number -> myLotto.getNumbers().contains(number))
                .count());

        boolean isBonus = winningLotto.getNumbers().stream()
                .anyMatch(number -> myLotto.getNumbers().contains(bonus));

        return new Result(Rank.calcRank(count, isBonus));
    }

    private static int safeLongToInt(long l) {
        int i = (int) l;
        if ((long) i != l) {
            throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
        }
        return i;
    }
}
