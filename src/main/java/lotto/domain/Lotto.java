package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int countMatches(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
