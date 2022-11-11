package lotto.domain;

import lotto.exception.LottoNumberException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int START = 1;
    private static final int END = 45;
    private final static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private final int number;

    static {
        for (int i = START; i <= END; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new LottoNumberException();
        }
        return of(Integer.parseInt(input));
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = lottoNumbers.get(number);
        if (!lottoNumbers.containsKey(number)) {
            throw new LottoNumberException();
        }
        return lottoNumber;
    }

    public int getNumber() {
        return number;
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

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
