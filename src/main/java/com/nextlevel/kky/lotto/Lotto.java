package com.nextlevel.kky.lotto;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkNumbersValidation(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void checkNumbersValidation(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6 || numbers.stream().anyMatch(num -> num > 45 || num < 0)) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다!");
        }
    }
}
