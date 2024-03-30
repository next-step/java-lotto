package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
    }


    public static LottoNumbers create(LottoNumberStrategy strategy) {
        return new LottoNumbers(strategy.numbers());
    }

    public int matchNumberCount(LottoNumbers winningNums) {
        return (int) winningNums.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(this.numbers);
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
        return numbers.hashCode();
    }
}
