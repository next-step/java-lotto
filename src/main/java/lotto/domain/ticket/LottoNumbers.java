package lotto.domain.ticket;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> numbers;

    LottoNumbers(List numbers) {
        this.numbers = numbers;
    }

    List getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    int getNumberOfDuplicatedNumbers(LottoNumbers target) {
        int numberOfDuplicatedNumbers = 0;

        for (int targetNumber : target.numbers) {
            numberOfDuplicatedNumbers += getNumberOfDuplicatedNumbers(targetNumber);
        }

        return numberOfDuplicatedNumbers;
    }

    private int getNumberOfDuplicatedNumbers(int target) {
        return (this.numbers.contains(target) ? 1 : 0);
    }
}
