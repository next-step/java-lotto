package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        IntStream.range(MIN_NUMBER, MAX_NUMBER).forEach(x -> lottoNumbers.put(x, new LottoNumber(x)));
    }

    public static LottoNumber of(int number) {
        return lottoNumbers.get(number);
    }

    private int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static Map<Integer, LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "" +
                number +
                "";
    }
}
