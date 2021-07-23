package lotto.helper;

import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {
    private Generator() {}

    public static List<LottoNumber> lottoNumbersOf(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
