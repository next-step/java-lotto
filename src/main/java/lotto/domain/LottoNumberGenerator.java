package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();
    private static final int MIN_RANGE_LOTTO_NUMBER = 1;
    private static final int MAX_RANGE_LOTTO_NUMBER = 46;
    private static LottoNumberGenerator lottoNumberGenerator;

    private LottoNumberGenerator() {
        IntStream.range(MIN_RANGE_LOTTO_NUMBER, MAX_RANGE_LOTTO_NUMBER).forEach(i -> numbers.put(i, new LottoNumber(i)));
    }

    public static LottoNumberGenerator getInstance() {
        if(lottoNumberGenerator == null) {
            lottoNumberGenerator = new LottoNumberGenerator();
        }

        return lottoNumberGenerator;
    }

    public LottoNumber valueOf(int number) {
        return numbers.get(number);
    }
}
