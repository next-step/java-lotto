package lotto.model;

import java.util.List;

public class Lotto {
    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = Numbers.valueOf(numbers);
    }

    public Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public MatchNumber matchNumbers(Numbers winningNumbers, Number bonusNumber) {
        return new MatchNumber(getMatchCount(winningNumbers), getMatchBonus(bonusNumber));
    }

    private boolean getMatchBonus(Number bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int getMatchCount(Numbers winningNumbers) {
        return (int) winningNumbers.getNumberList().stream()
                .parallel()
                .filter(number -> getMatchBonus(number))
                .count();
    }
}
