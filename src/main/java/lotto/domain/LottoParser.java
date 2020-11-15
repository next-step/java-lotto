package lotto.domain;

import lotto.asset.LottoConst;
import lotto.exception.NanException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {
    private LottoParser() {}

    public static List<Integer> parseLottoStr(String lottoStr) {
        return splitLottoStr(lottoStr)
                .stream()
                .map(LottoParser::parseInt)
                .collect(Collectors.toList());
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw NanException.getInstance();
        }
    }

    private static List<String> split(String str, String regex) {
        return Arrays.asList(
                str.split(regex)
        );
    }

    static List<String> splitLottoStr(String lottoStr) {
        return split(lottoStr, LottoConst.SPLIT_REGEX);
    }
}
