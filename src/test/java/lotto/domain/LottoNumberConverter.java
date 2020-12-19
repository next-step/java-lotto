package lotto.domain;

import lotto.domain.numbers.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberConverter {
    public static List<LottoNumber> of(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }
}
