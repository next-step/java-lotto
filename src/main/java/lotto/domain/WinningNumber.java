package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningNumber(Integer bonusNumber) {
        this(new ArrayList<>(), bonusNumber);
    }

    public WinningNumber(List<Integer> numbers) {
        this(numbers, 0);
    }

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        validateIfNotNull();
        validateIfBonusNumberNotInNumbers();
    }

    private void validateIfNotNull() {
        if(numbers == null || bonusNumber == null) throw new IllegalArgumentException();
    }

    private void validateIfBonusNumberNotInNumbers() {
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
