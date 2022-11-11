package step2_pobi.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    private static final String EXCEPTION_MESSAGE = "로또 번호의 범위를 벗어났습니다.";

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();
    private final int number;

    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String text) {
        return of(Integer.parseInt(text));
    }

    public static LottoNumber of(int no) {
        LottoNumber lottoNumber = lottoNumbers.get(no);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return lottoNumber;
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
