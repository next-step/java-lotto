package lotto.entity;

import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int collectResult(int winningCount, Integer winningNumber) {
        if (this.numbers.contains(winningNumber)) {
            return ++winningCount;
        }
        return winningCount;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
