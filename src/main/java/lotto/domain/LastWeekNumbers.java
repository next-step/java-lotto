package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LastWeekNumbers {

    private static final String DELIMITER = ",";
    private static final int MUST_LOTTO_COUNT = 6;

    private final List<Integer> lastWeekNumbers;

    public LastWeekNumbers(String lastWeekNumbersValue) {

        this.lastWeekNumbers = parse(lastWeekNumbersValue);
        validate();
    }

    public LastWeekNumbers(List<Integer> lastWeekNumbers) {

        this.lastWeekNumbers = lastWeekNumbers;
        validate();
    }

    private List<Integer> parse(String lastWeekNumbersValue) {

        return Arrays.stream(lastWeekNumbersValue.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate() {

        if (lastWeekNumbers == null || lastWeekNumbers.size() != MUST_LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 개수는 " + MUST_LOTTO_COUNT + "개 여야 합니다.");
        }
    }

    public List<Integer> getLastWeekNumbers() {

        return lastWeekNumbers;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastWeekNumbers that = (LastWeekNumbers) o;
        return Objects.equals(lastWeekNumbers, that.lastWeekNumbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lastWeekNumbers);
    }
}
