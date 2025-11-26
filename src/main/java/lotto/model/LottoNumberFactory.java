package lotto.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class LottoNumberFactory {
    private final static Map<Integer, LottoNumber> CACHE;

    static {
        CACHE = new ConcurrentHashMap<>();
        IntStream.rangeClosed(1, 45).forEach(i -> CACHE.put(i, new LottoNumber(i)));
    }

    public static LottoNumber get(String number) {
        return get(Integer.parseInt(number));
    }

    public static LottoNumber get(Integer number) {
        if (CACHE.get(number) == null) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return CACHE.get(number);
    }
}
