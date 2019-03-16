package lotto.parser;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberParser {
    private LottoNumberParser() {
    }

    public static Lotto parse(String lottoNumbersString) {
        return new Lotto(parseToIntList(lottoNumbersString));
    }

    static List<Integer> parseToIntList(String lottoNumbersString) {
        lottoNumbersString = removeWhiteSpace(lottoNumbersString);

        return Arrays.stream(lottoNumbersString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    static String removeWhiteSpace(String source) {
        return source.replaceAll("\\s+", "");
    }
}
