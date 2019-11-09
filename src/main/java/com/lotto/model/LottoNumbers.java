package com.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private final List<Integer> numbers = new ArrayList<>();

    public LottoNumbers() {
        for (int number = 1; number <= 45; number++) {
            numbers.add(number);
        }
    }

    public List<Integer> shuffle() {
        Collections.shuffle(numbers);
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
