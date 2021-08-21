package com.lotto.model;

import java.util.Collections;
import java.util.Set;

public class WinningNumbers {
    private static final int NUMBER_OF_WINNING_NUMBERS = 6;

    private final Set<Integer> numbers;

    private final int bonusNumber;

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    public WinningNumbers(Set<Integer> numbers, int bonusNumber) {
        validateNumbers(numbers);
        validateBonusNumber(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Set<Integer> numbers, int bonusNumber){
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자가 이미 뽑힌 숫자들에 포함되어 있습니다.");
        }

        if (isInvalidRange(bonusNumber)) {
            throw new IllegalArgumentException("잘못된 보너스 숫자가 입력되었습니다. " + numbers);
        }
    }

    private void validateNumbers(Set<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_WINNING_NUMBERS) {
            throw new IllegalArgumentException("잘못된 갯수의 숫자가 입력되었습니다. " + numbers);
        }

        if (numbers.stream().anyMatch((number) -> isInvalidRange(number))) {
            throw new IllegalArgumentException("잘못된 숫자가 입력되었습니다. " + numbers);
        }
    }

    private boolean isInvalidRange(int number) {
        return number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
