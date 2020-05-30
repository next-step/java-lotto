package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final List<Integer> DEFAULT_LOTTO_NUMBERS;

    private LottoNumbers() {}

    static {
        DEFAULT_LOTTO_NUMBERS = IntStream.range(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> getDefaultLottoNumbers() {
        return DEFAULT_LOTTO_NUMBERS.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
