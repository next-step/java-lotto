package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import step3.util.LotteryUtil;

public class Lottery {

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lottery of(Set<Integer> numbers) {
        return new Lottery(new ArrayList<>(numbers));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (LotteryUtil.WINNING_STREAK != numbers.size()) {
            throw new IllegalArgumentException("잘 못 생성된 로또 - " + numbers.size());
        }
    }
}
