package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import lotto.domain.util.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(Integer... numbers) {
        if (numbers.length != LottoConstant.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoConstant.NUMBER_COUNT_EXCEPTION);
        }
        this.numbers = Arrays.asList(numbers);
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoConstant.NUMBER_COUNT_EXCEPTION);
        }
        this.numbers = numbers;
    }

    public Lotto(String numberString) {
        StringTokenizer stringTokenizer =
            new StringTokenizer(numberString, ",");

        if (stringTokenizer.countTokens() != LottoConstant.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoConstant.NUMBER_COUNT_EXCEPTION);
        }
        numbers = new ArrayList<>(stringTokenizer.countTokens());

        while (stringTokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken().trim()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf)
                               .collect(Collectors.joining(", "));
    }

    public long countWinnerNumbersIn(Lotto winner) {
        return winner.numbers.stream().mapToLong(this::traverseCompareTo).sum();
    }

    private long traverseCompareTo(int winnerNumber) {
        return numbers.stream().filter(num -> num == winnerNumber).count();
    }

}
