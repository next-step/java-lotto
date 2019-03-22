package lotto.parser;

import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberParser {
    private LottoNumberParser() {
    }

    public static WinningLotto parse(String lottoNumbersString, String bonusNumber) {
        return new WinningLotto(parseToIntList(lottoNumbersString), Integer.parseInt(bonusNumber));
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
