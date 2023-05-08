package lotto.domain.number;

import lotto.domain.LottoConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberCache {

    public static final List<LottoNumber> LOTTO_NUMBER_CACHE = new ArrayList<>();

    static {
        IntStream.rangeClosed(LottoConstant.MIN_LOTTO_NUMBER, LottoConstant.MAX_LOTTO_NUMBER)
                .forEach(number -> LOTTO_NUMBER_CACHE.add(new LottoNumber(number)));
    }
}
