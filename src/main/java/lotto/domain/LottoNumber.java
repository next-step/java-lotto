package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private PositiveNumber number;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = Lotto.START_NUMBER; i <= Lotto.END_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber of(int value) {
        numberRangeCheck(value);
        return lottoNumbers.get(value);
    }

    public static LottoNumber of(String value) {
        int valueNumber = Parser.parseNumberFormat(value);
        numberRangeCheck(valueNumber);
        return lottoNumbers.get(valueNumber);
    }

    private LottoNumber(int value) {
        numberRangeCheck(value);
        this.number = new PositiveNumber(value);
    }

    private static void numberRangeCheck(int value) {
        if (value < Lotto.START_NUMBER || value > Lotto.END_NUMBER) {
            throw new IllegalArgumentException("숫자 범위를 벗어납니다. 숫자범위 : 1~45");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number.compareTo(o.number);
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
