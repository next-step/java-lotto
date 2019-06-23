package lotto.domain;

import lotto.utils.LottoNumberValidator;

import java.util.*;
import java.util.stream.Collectors;

public class WonNumbers {

    private static final String DELIMITER = ",";

    private final List<Integer> wonNumbers;

    public WonNumbers(String wonNumbersValue) {

        if (wonNumbersValue == null || wonNumbersValue.isEmpty()) {
            throw new IllegalArgumentException("입력받은 우승번호가 유효하지 않습니다.");
        }

        List<Integer> wonNumbers = parse(wonNumbersValue);
        LottoNumberValidator.validate(wonNumbers);
        this.wonNumbers = wonNumbers;
    }

    private List<Integer> parse(String wonNumbersValue) {

        return Arrays.stream(wonNumbersValue.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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
