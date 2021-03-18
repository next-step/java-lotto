package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    protected static final int MIN_NUMBER = 1;
    protected static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int number;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String stringNumber) {
        return of(Integer.parseInt(stringNumber));
    }

    public static LottoNumber of(int no) {
        LottoNumber lottoNumber = lottoNumbers.get(no);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("올바르지 않는 로또 번호입니다.");

        }
        return lottoNumber;
    }

    public int toNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
