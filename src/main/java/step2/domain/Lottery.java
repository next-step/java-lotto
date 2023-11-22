package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import step2.util.LotteryUtil;

public class Lottery {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lottery(List<Integer> numbers, int bonusNumber) {
        validateNumbers(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static Lottery of(Set<Integer> numbers) {
        return new Lottery(new ArrayList<>(numbers), 0);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (LotteryUtil.WINNING_STREAK != numbers.size()) {
            throw new IllegalArgumentException("잘 못 생성된 로또 - " + numbers.size());
        }
    }
}
