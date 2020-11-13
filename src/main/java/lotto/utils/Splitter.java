package lotto.utils;

import lotto.asset.LottoConst;
import lotto.utils.validator.GeneralValidator;
import lotto.utils.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    private Splitter() {}

    private static List<String> split(String str, String regex) {
        GeneralValidator.validateNpe(str);
        GeneralValidator.validateNpe(regex);
        return Arrays.asList(
                str.split(regex)
        );
    }

    public static List<String> splitLottoStr(String lottoStr) {
        LottoValidator.validateLottoStr(lottoStr);
        return split(lottoStr, LottoConst.SPLIT_REGEX);
    }
}
