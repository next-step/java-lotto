package step3.lotto.util;

import step3.lotto.util.LottoErrorMessage;

import java.util.List;

/**
 * 공통적인 로또 번호
 */
public class CommonLottoCheck {

    private static int HIGH_STANDARD_NUMBER = 45; //로또 번호 최대
    private static int LOW_STANDARD_NUMBER = 1;   //로또 번호 최소
    private static int LOTTO_NUBMER_COUNT = 6;    //로또 생성 및 당천번호 갯수

    private CommonLottoCheck(){

    }

    public static void CheckNumber(List<String> lottoNumbers) {
        isNumberCount(lottoNumbers);
        isSameValueCheck(lottoNumbers);

        for (String str : lottoNumbers) {
            checkStandardNumber(str);
        }
    }

    private static void isNumberCount(List<String> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUBMER_COUNT) {
            throw new RuntimeException(LottoErrorMessage.getLottoIncorrectCount());
        }
    }

    private static void isSameValueCheck(List<String> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size()-1; i++) {
            if(lottoNumbers.get(i).equals(lottoNumbers.get(i+1))){
                throw new RuntimeException(LottoErrorMessage.getLottoOverlapCheck());
            }
        }
    }

    private static void checkStandardNumber(String paramValue) {
        int checkParamValue = isLottoNumber(paramValue);

        checkLowStandardNumber(checkParamValue);
    }

    public static void checkLowStandardNumber(Integer paramValue) {
        if (paramValue > HIGH_STANDARD_NUMBER || paramValue < LOW_STANDARD_NUMBER) {
            throw new RuntimeException(LottoErrorMessage.getLottoRuntimeexception());
        }
    }

    private static Integer isLottoNumber(String paramValue) {
        try {
            return Integer.parseInt(paramValue);
        } catch (NumberFormatException e) {
            System.out.println(e.toString() + " : " + LottoErrorMessage.getLottoNumberformatexception());
        }

        return Integer.parseInt(paramValue);
    }
}
