package step4.domain.lotto;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class LottoNumber {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final String LIMIT_NUMBER_EXCEPTION = "로또번호는 1~45까지의 숫자만 올 수 있습니다.";
    private static final Map<Integer, LottoNumber> CACHING_NUMBERS;

    private final int number;

    static {
        CACHING_NUMBERS = new TreeMap<>();
        for (int number = MIN_LOTTO_NUM; number <= MAX_LOTTO_NUM; number++) {
            CACHING_NUMBERS.put(number, new LottoNumber(number));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(LIMIT_NUMBER_EXCEPTION);
        }

        return CACHING_NUMBERS.get(number);
    }

    public int getNumber() {
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
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + "";
    }
}
