package lotto.utils.validator;

import lotto.asset.LottoConst;
import lotto.exception.LottoRangeException;

public class LottoNoValidator {
    private LottoNoValidator() {}

    protected static boolean checkLottoRange(int lottoNo) {
        boolean lessThanMax = lottoNo <= LottoConst.NO_MAX;
        boolean biggerThanMin = lottoNo >= LottoConst.NO_MIN;
        return lessThanMax && biggerThanMin;
    }


    public static void validateLottoNo(int lottoNo) {
        if (!checkLottoRange(lottoNo)) {
            throw LottoRangeException.getInstance();
        }
    }

    public static void validateLottoNo(String lottoNoStr) {
        GeneralValidator.validateStrNum(lottoNoStr);
        validateLottoNo(Integer.parseInt(lottoNoStr));
    }
}
