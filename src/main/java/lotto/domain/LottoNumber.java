package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    List<Integer> numbers;

    public LottoNumber(List<Integer> numbers, LottoRule lottoRule) {
        if (numbers.stream().max(Integer::compare).get() > lottoRule.max()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().min(Integer::compare).get() < lottoRule.min()) {
            throw new IllegalArgumentException();
        }

        if (numbers.stream().distinct().count() != lottoRule.countOfSelection()) {
            throw new IllegalArgumentException();
        }

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int countOfMatch(LottoNumber lottoNumber) {
        return (int) this.numbers
                .stream()
                .filter(lottoNumber::contains)
                .count();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
