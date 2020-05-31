package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {

    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS;

    static {
        DEFAULT_LOTTO_NUMBERS = IntStream.range(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX + 1)
                .mapToObj(LottoNumber::of)
                .collect(toList());
    }

    public static List<LottoNumber> getDefaultLottoNumbers() {
        return DEFAULT_LOTTO_NUMBERS;
    }
}
