package lotto.utils;

import lotto.asset.LottoConst;
import lotto.utils.validator.GeneralValidator;
import lotto.utils.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {
    private LottoParser() {}

    private static List<String> split(String str, String regex) {
        GeneralValidator.validateNpe(str);
        GeneralValidator.validateNpe(regex);
        return Arrays.asList(
                str.split(regex)
        );
    }

    protected static List<String> splitLottoStr(String lottoStr) {
        return split(lottoStr, LottoConst.SPLIT_REGEX);
    }

    public static List<Integer> parseLottoStr(String lottoStr) {
        LottoValidator.validateLottoStr(lottoStr);
        return splitLottoStr(lottoStr)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
