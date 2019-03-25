package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> basicLottoNumbers = new HashMap<>();
    static{
        IntStream.range(1, 46)
            .forEach(basicNumber -> basicLottoNumbers.put(basicNumber, new LottoNumber(basicNumber)));
    }

    private final int basicNumber;


    public LottoNumber(int basicNumber) {
        this.basicNumber = basicNumber;
        if (isCheckDigits(this.basicNumber)) {
            throw new IllegalArgumentException("로또 기본 숫자범위 다름  1 ~ 45의 값");
        }
    }

    public static LottoNumber getBasicNumber(int parseInt) {

        return basicLottoNumbers.get(parseInt);
    }

    private boolean isCheckDigits(int basicNumber) {
        return basicNumber < 1 || basicNumber > 45;
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
            + basicNumber + "";
    }
}
