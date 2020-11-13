package lotto.utils.validator;

import lotto.asset.LottoConst;
import lotto.exception.BadNumOfLottoNoException;

import java.util.List;

public class LottoValidator {
    private LottoValidator() {}

    public static void validateLottoStr(String lottoStr) {
        GeneralValidator.validateNpe(lottoStr);
        String[] lottoNos = lottoStr.split(LottoConst.SPLIT_REGEX);
        validateNumOfLottoNo(lottoNos.length);
        for (String lottoNo : lottoNos) {
            GeneralValidator.validateNan(lottoNo);
            LottoNoValidator.validateLottoNo(
                    Integer.parseInt(lottoNo)
            );
        }
    }

    public static void validateLottoNos(List<Integer> lottoNos) {
        int numOfLottoNo = lottoNos.size();
        validateNumOfLottoNo(numOfLottoNo);
        for (int lottoNo : lottoNos) {
            LottoNoValidator.validateLottoNo(lottoNo);
        }
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
