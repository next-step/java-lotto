package lotto.domain;

import lotto.exception.CustomIllegalArgumentException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) throws CustomIllegalArgumentException {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (lottoNumber == null) {
            throw new CustomIllegalArgumentException(Message.ERROR_LOTTO_NUMBER_OUT_OF_RANGE,
                    MIN_VALUE, MAX_VALUE);
        }
        return lottoNumber;
    }

    public int number() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
