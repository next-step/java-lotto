package lotto.entity;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
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
