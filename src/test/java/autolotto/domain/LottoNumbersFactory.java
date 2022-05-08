package autolotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbersFactory {

    public Set<LottoNumber> of(String numbersAsString) {
        return Arrays.stream(numbersAsString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public Set<LottoNumber> from(Set<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
