package lotto.model;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasSixNumbers(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getWinningCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream().filter(winnerNumber -> this.numbers.contains(winnerNumber)).count();
    }
}
