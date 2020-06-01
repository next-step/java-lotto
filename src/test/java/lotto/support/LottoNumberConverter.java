package lotto.support;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberConverter {

    public static Set<LottoNumber> of(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
