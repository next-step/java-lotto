package lotto.util;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberConverter {
    public static List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
