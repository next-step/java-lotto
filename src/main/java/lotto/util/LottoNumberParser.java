package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberParser {

    private static final String DELIMITER = ", ";

    public static Set<LottoNumber> parseToSet(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static String parseToString(Set<LottoNumber> winNumbers) {
        return winNumbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }
}
