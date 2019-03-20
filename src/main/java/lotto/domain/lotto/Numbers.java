package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    private List<LottoNumber> numbers;

    public Numbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public void sort() {
        Collections.sort(this.numbers);
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public int matchCount(Numbers target) {
        int matchCount = 0;
        for (LottoNumber number : target.numbers) {
            matchCount += count(number);
        }
        return matchCount;
    }

    private int count(LottoNumber number) {
        if (this.contains(number))
            return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }
}
