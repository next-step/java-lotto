package lotto.lib;

import lotto.asset.LottoConst;
import lotto.exception.BadNumOfLottoNoException;

public class LottoValidator {
    private LottoValidator() {}

    public static void validateLottoStr(String lottoStr) {
        GeneralValidator.validateNpe(lottoStr);
        String[] lottoNoArr = getLottoNoArr(lottoStr);
        validateLottoNoArr(lottoNoArr);
    }

    private static void validateLottoNoArr(String[] lottoNoArr) {
        int numOfLottoNo = lottoNoArr.length;
        validateNumOfLottoNo(numOfLottoNo);
        for (String lottoNo: lottoNoArr) {
            LottoNoValidator.validateLottoNo(lottoNo);
        }
    }

    private static String[] getLottoNoArr(String lottoStr) {
        return lottoStr.split(LottoConst.splitRegex);
    }

    private static boolean checkNumOfLottoNo(int numOfLottoNo) {
        return numOfLottoNo != LottoConst.NUM_OF_LOTTO_NO;
    }

    private static void validateNumOfLottoNo(int numOfLottoNo) {
        if (checkNumOfLottoNo(numOfLottoNo)) {
            throw BadNumOfLottoNoException.getInstance();
        }
    }
}
