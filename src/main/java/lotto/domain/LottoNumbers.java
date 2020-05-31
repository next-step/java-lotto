package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {

    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS;

    private final List<LottoNumber> lottoNumbers;

    static {
        DEFAULT_LOTTO_NUMBERS = IntStream.range(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX + 1)
                .mapToObj(LottoNumber::of)
                .collect(toList());
    }

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public static LottoNumbers of(int... lottoValues) {
        return new LottoNumbers(Arrays.stream(lottoValues)
                .mapToObj(LottoNumber::of)
                .collect(toList()));
    }

    public static List<LottoNumber> getDefaultLottoNumbers() {
        return DEFAULT_LOTTO_NUMBERS;
    }
}
