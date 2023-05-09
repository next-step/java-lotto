package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbersParser {

    public static Set<LottoNumber> parseToSet(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(number -> new LottoNumber(Integer.parseInt(number.trim())))
                .collect(Collectors.toUnmodifiableSet());
    }
}
