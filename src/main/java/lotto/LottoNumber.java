package lotto;

import configuration.LottoConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(LottoConfiguration.LOTTO_RANGE_MIN, LottoConfiguration.LOTTO_RANGE_MAX)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private int number;
    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return lottoNumberCache.get(number);
    }

    public int getNumber() {
        return number;
    }
}
