package lotto.domain.number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberCache {

    public static final List<LottoNumber> LOTTO_NUMBER_CACHE = new ArrayList<>();

    static {
        IntStream.range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .forEach(number -> LOTTO_NUMBER_CACHE.add(number, new LottoNumber(number)));
    }

    public static LottoNumber valueOf(final int number) {
        LottoNumber.validateLottoNumber(number);
        return LOTTO_NUMBER_CACHE.get(number);
    }
}
