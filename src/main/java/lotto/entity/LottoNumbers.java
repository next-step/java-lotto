package lotto.entity;

import java.util.Collections;
import java.util.List;

public class LottoNumbers extends Numbers {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            super.validateRange(number);
        }
        super.validateDuplication(numbers);
        super.validateSize(numbers);
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchCount(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
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
