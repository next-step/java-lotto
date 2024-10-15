package lotto.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private final Set<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this(new HashSet<>(numbers));
    }

    public LottoNumbers(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<Integer> numbers) {
        for (Integer number : numbers) {
            LottoNumberRange.validateRange(number);
        }
        LottoNumberSize.validateSize(numbers);
    }


    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(Set<Integer> winningNumbers) {
        int count = 0;
        for (Integer winningNumber : winningNumbers) {
            count = match(count, winningNumber);
        }
        return count;
    }

    private int match(int count, Integer winningNumber) {
        if (this.numbers.contains(winningNumber)) {
            return ++count;
        }
        return count;
    }

}
