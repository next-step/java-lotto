package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final Map<Integer,LottoNumber> NUMBERS = new HashMap<>();
    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        vaildate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    static {
        IntStream.range(MIN_NUMBER, MAX_NUMBER)
                .forEach(num -> {
                    NUMBERS.put(num,new LottoNumber(num));
                });
    }

    private static void vaildate(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER || MAX_NUMBER < lottoNumber) {
            throw new IllegalArgumentException("숫자 범위 벗어남");
        }
    }

    public static LottoNumber getLottoNumber(int lottoNumber) {
        vaildate(lottoNumber);
        return NUMBERS.get(lottoNumber);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof LottoNumber) {
            return this.lottoNumber == ((LottoNumber) obj).lottoNumber;
        }

        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
