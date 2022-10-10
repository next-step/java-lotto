package com.game.lotto.number;

import java.util.List;

public class ManualLottoNumberGenerator extends LottoNumberGenerator {

    private final List<Integer> numbers;

    public ManualLottoNumberGenerator(List<Integer> numbers) {
        isValidNumbers(numbers);
        for (int number : numbers) {
            isValidNumber(number);
        }
        this.numbers = numbers;
    }

    private void isValidNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBER_SELECT_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SELECT_COUNT + "개가 입력되어야 합니다!");
        }
    }

    private void isValidNumber(int intValueOfNumber) {
        if (intValueOfNumber < MIN_VALUE_OF_LOTTO_NUMBER || intValueOfNumber > MAX_VALUE_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_VALUE_OF_LOTTO_NUMBER + "부터 " + MAX_VALUE_OF_LOTTO_NUMBER + " 사이의 숫자만 입력되어야 합니다!");
        }
    }

    @Override
    public List<Integer> generateNumbers() {
        return this.numbers;
    }
}
