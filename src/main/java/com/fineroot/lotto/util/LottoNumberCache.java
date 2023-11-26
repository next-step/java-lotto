package com.fineroot.lotto.util;

import com.fineroot.lotto.domain.LottoNumber;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberCache {
    private static final List<LottoNumber> cache = Stream.iterate(1, i -> i + 1).limit(45)
            .map(LottoNumber::from)
            .collect(Collectors.toList());

    private LottoNumberCache() {
        throw new IllegalArgumentException(ExceptionMessage.UTILITY_CLASS.getMessage());
    }

    public static Set<LottoNumber> createLottoNumberSet() {
        Collections.shuffle(cache);
        return cache.stream().limit(6).collect(Collectors.toSet());
    }

    public static LottoNumber fromLottoNumber(final int number) {
        return cache.stream().filter(e -> e.isSameAs(number)).findFirst().orElseThrow(
                () -> new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage()));
    }
}
