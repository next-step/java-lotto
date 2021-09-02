package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int SAVED_MIN_NUMBER = 1;
    public static final int SAVED_MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private static final String LOTTO_NUMBERS_INVALID_RANGE_ERROR_MESSAGE = "로또 번호는 1이상 45이하의 수만 들어올 수 있다.";

    private final int number;

    static {
        for (int i = SAVED_MIN_NUMBER; i <= SAVED_MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_RANGE_ERROR_MESSAGE);
        }
        return lottoNumber;
    }

    public static List<LottoNumber> generateNumbers(String[] inputs) {
        return Arrays.stream(inputs)
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

}
