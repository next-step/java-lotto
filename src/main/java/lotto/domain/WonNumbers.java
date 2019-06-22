package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WonNumbers {

    private static final String DELIMITER = ",";
    private static final int MUST_LOTTO_COUNT = 6;

    private final List<Integer> wonNumbers;

    public WonNumbers(String wonNumbersValue) {

        this.wonNumbers = parse(wonNumbersValue);
        validate();
    }

    public WonNumbers(List<Integer> wonNumbers) {

        this.wonNumbers = wonNumbers;
        validate();
    }

    private List<Integer> parse(String wonNumbersValue) {

        return Arrays.stream(wonNumbersValue.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate() {

        if (wonNumbers == null || wonNumbers.size() != MUST_LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 개수는 " + MUST_LOTTO_COUNT + "개 여야 합니다.");
        }
    }

    public List<Integer> getWonNumbers() {

        return wonNumbers;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WonNumbers that = (WonNumbers) o;
        return Objects.equals(wonNumbers, that.wonNumbers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(wonNumbers);
    }
}
