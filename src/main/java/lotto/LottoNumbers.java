package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class LottoNumbers {
    private static final int MIN = 1;
    private static final int MAX = 45;
    public static final String DELIMITER = ",";
    private static final List<Integer> NUMBERS = rangeClosed(MIN, MAX).boxed().collect(toList());

    private final List<Integer> values;

    public LottoNumbers() {
        this.values = lottoNumbers();
    }

    public LottoNumbers(String values) {
        this(Arrays.stream(values.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
    }

    public LottoNumbers(List<Integer> values) {
        this.values = values;
    }

    public boolean result(LottoNumbers winningNumbers, Condition condition) {
        long count = values.stream()
                .filter(value -> winningNumbers.getValues().contains(value))
                .count();
        return condition.isEqualsTo(count);
    }

    public List<Integer> getValues() {
        return values;
    }

    private List<Integer> lottoNumbers() {
        Collections.shuffle(NUMBERS);

        return NUMBERS.stream()
                .limit(6)
                .sorted()
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
