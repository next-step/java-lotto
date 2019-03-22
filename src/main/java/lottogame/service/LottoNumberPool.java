package lottogame.service;

import lottogame.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberPool {

    private static final List<LottoNumber> lottoNumberPool =
            IntStream.rangeClosed(LottoNumber.MINIMUM_LOTTO_NUMBER, LottoNumber.MAXIMUM_LOTTO_NUMBER)
                    .boxed()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());

    public static LottoNumber getLottoNumber(int number) {
        return lottoNumberPool.get(number-1);
    }
}