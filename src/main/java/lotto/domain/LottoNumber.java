package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int BASIC_LOTTO_MIN_NUMBER = 1;
    public static final int BASIC_LOTTO_MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> basicLottoNumbers = new HashMap<>();

    static {
        IntStream.rangeClosed(BASIC_LOTTO_MIN_NUMBER, BASIC_LOTTO_MAX_NUMBER)
            .forEach(basicNumber -> basicLottoNumbers.put(basicNumber, new LottoNumber(basicNumber)));
    }

    private final int basicNumber;

    private LottoNumber(int basicNumber) {
        if (isNotLottoNumber(basicNumber)) {
            throw new IllegalArgumentException("로또 기본 숫자범위 다름  1 ~ 45의 값");
        }
        this.basicNumber = basicNumber;
    }

    public static LottoNumber getBasicNumber(int number) {

        return Optional.ofNullable(basicLottoNumbers.get(number))
            .orElseThrow(() -> new IllegalArgumentException("로또 기본 숫자범위 다름  1 ~ 45의 값"));
    }


    private boolean isNotLottoNumber(int basicNumber) {
        return basicNumber < BASIC_LOTTO_MIN_NUMBER || basicNumber > BASIC_LOTTO_MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return basicNumber == that.basicNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basicNumber);
    }

    @Override
    public String toString() {
        return "" +
            +basicNumber + "";
    }
}
