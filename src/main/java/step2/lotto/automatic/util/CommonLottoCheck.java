package step2.lotto.automatic.util;

import java.util.List;

/**
 * 공통적인 로또 번호
 */
public class CommonLottoCheck {

    private static int HIGH_STANDARD_NUMBER = 45; //로또 번호 최대
    private static int LOW_STANDARD_NUMBER = 1;   //로또 번호 최소
    private static int LOTTO_NUBMER_COUNT = 6;    //로또 생성 및 당천번호 갯수

    public void CheckNumber(List<String> lottoNumbers) {
        isNumberCount(lottoNumbers);

        for (String str : lottoNumbers) {
            CheckStandardNumber(str);
        }
    }

    private void isNumberCount(List<String> lottoNumbers){
        if(lottoNumbers.size() != LOTTO_NUBMER_COUNT){
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2IncorrectCount());
        }
    }



    private void CheckStandardNumber(String paramValue) {
        int checkParamValue = isLottoNumber(paramValue);

        CheckLowStandardNumber(checkParamValue);

    }

    private static Integer isLottoNumber(String paramValue) {
        try {
            return Integer.parseInt(paramValue);
        } catch (NumberFormatException e) {
            System.out.println(e.toString() + " : " + LottoStep2ErrorMessage.getLottoStep2Numberformatexception());
        }

        return Integer.parseInt(paramValue);
    }

    private void CheckLowStandardNumber(Integer paramValue) {
        if (paramValue >= HIGH_STANDARD_NUMBER && paramValue <= LOW_STANDARD_NUMBER) {
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2Runtimeexception());
        }
    }
}
