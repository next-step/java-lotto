package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WonNumbers {

    private static final String DELIMITER = ",";
    private static final int MUST_LOTTO_COUNT = 6;

    private final List<Integer> wonNumbers;

    public WonNumbers(String wonNumbersValue) {

        if (wonNumbersValue == null || wonNumbersValue.isEmpty()) {
            throw new IllegalArgumentException("입력받은 우승번호가 유효하지 않습니다.");
        }

        List<Integer> wonNumbers = parse(wonNumbersValue);
        validate(wonNumbers);
        this.wonNumbers = wonNumbers;
    }

    private List<Integer> parse(String wonNumbersValue) {

        return Arrays.stream(wonNumbersValue.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> wonNumbers) {

        if (wonNumbers == null || wonNumbers.size() != MUST_LOTTO_COUNT) {
            throw new IllegalArgumentException("우승번호 개수는 " + MUST_LOTTO_COUNT + "개 여야 합니다.");
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
