package lotto.utils.validator;

import lotto.asset.LottoConst;
import lotto.exception.BadNumOfLottoNoException;

import java.util.Arrays;
import java.util.List;

public class LottoValidator {
    private LottoValidator() {}

    public static void validateLottoStr(String lottoStr) {
        GeneralValidator.validateNpe(lottoStr);
        List<String> lottoNos = getLottoNos(lottoStr);
        validateLottoNoStrList(lottoNos);
    }

    public static void validateLottoNoIntList(List<Integer> lottoNos) {
        int numOfLottoNo = lottoNos.size();
        validateNumOfLottoNo(numOfLottoNo);
        for (int lottoNo : lottoNos) {
            LottoNoValidator.validateLottoNo(lottoNo);
        }
    }

    public static void validateLottoNoStrList(List<String> lottoNos) {
        int numOfLottoNo = lottoNos.size();
        validateNumOfLottoNo(numOfLottoNo);
        for (String lottoNo : lottoNos) {
            LottoNoValidator.validateLottoNo(lottoNo);
        }
    }

    private static List<String> getLottoNos(String lottoStr) {
        return Arrays.asList(
                lottoStr.split(LottoConst.SPLIT_REGEX)
        );
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
