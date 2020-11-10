package lotto.lib;

import lotto.asset.LottoNoConst;
import lotto.exception.LottoNoException;

public class Validator {
    public static boolean validateLottoRange(int lottoNo) {
        boolean lessThanMax = lottoNo <= LottoNoConst.LOTTO_NO_MAX;
        boolean biggerThanMin = lottoNo >= LottoNoConst.LOTTO_NO_MIN;
        return lessThanMax && biggerThanMin;
    }

    public static boolean validateNan(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
