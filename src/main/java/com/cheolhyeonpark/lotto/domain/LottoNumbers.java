package com.cheolhyeonpark.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
