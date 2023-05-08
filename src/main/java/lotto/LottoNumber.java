package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private final int number;

    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();

    private LottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("number은 1에서 45까지 값을 가져야합니다.");
        }
        this.number = number;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = numbers.get(number);
        if (lottoNumber == null) {
            LottoNumber newLottoNumber = new LottoNumber(number);
            numbers.put(number, newLottoNumber);
            return newLottoNumber;
        }
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number+"";
    }
}
