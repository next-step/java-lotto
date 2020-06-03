package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberPool {
    private final static Map<Integer, LottoNumber> LOTTO_NUMBER_POOL =
            Collections.unmodifiableMap(
                    IntStream.rangeClosed(LottoNumber.LOTTO_START_NUMBER, LottoNumber.LOTTO_LAST_NUMBER).boxed()
                        .collect(Collectors.toMap(Integer::new, LottoNumber::of)));

    public static LottoNumber get(int number) {
        return LOTTO_NUMBER_POOL.get(number);
    }

    public static List<LottoNumber> get(Integer... numbers) {
        return Arrays.stream(numbers).map(LottoNumber::of).collect(Collectors.toList());
    }
}
