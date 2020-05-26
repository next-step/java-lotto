package lotto.util;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGenerator {

    private LottoNumbersGenerator() {
    }

    public static LottoNumbers valueOf(final int... numbers) {
        return LottoNumbers.manualCreate(toLottoNumberList(numbers));
    }

    public static List<LottoNumber> toLottoNumberList(final int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
