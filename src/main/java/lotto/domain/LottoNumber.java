package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber {
    private static int MIN = 1;
    private static int MAX = 45;
    private static int COUNT_OF_SELECTION = 6;

    List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        if (numbers.stream().max(Integer::compare).get() > MAX) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().min(Integer::compare).get() < MIN) {
            throw new IllegalArgumentException();
        }

        if (numbers.stream().distinct().count() != COUNT_OF_SELECTION) {
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
