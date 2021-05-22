package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();
    private final int number;

    static {
        IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
            .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(String number) {
        return of(Integer.parseInt(number.trim()));
    }

    public static LottoNumber of(int number) {
        return Optional.ofNullable(lottoNumberCache.get(number))
            .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 로또번호입니다."));
    }
}
