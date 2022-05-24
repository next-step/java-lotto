package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int LOTTO_ALL_NUMBER = 45;
    public static final int LOTTO_MINIMUM_NUMBER = 1;

    private static Map<Integer, LottoNumber> allLottoNumbers = new HashMap<>();

    static {
        IntStream.range(LOTTO_MINIMUM_NUMBER, LOTTO_ALL_NUMBER)
                .forEach(number -> allLottoNumbers.put(number, new LottoNumber(number)));
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        LottoNumber temporaryLottoNumber = allLottoNumbers.get(lottoNumber);
        if (temporaryLottoNumber == null) {
            throw new IllegalArgumentException("로또숫자의 범위가 올바르지 않습닌다.");
        }
        return temporaryLottoNumber;
    }

    public static LottoNumber of(String lottoNumber) {
        return of(Integer.parseInt(lottoNumber));
    }

    public boolean isSameNumber(LottoNumber lottoNumber) {
        return this.equals(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
    }
}
