package step4.lotto.util;

import java.util.List;

/**
 * 공통적인 로또 번호
 */
public class CommonLottoCheck {

    private static int HIGH_STANDARD_NUMBER = 45; //로또 번호 최대
    private static int LOW_STANDARD_NUMBER = 1;   //로또 번호 최소
    private static int LOTTO_NUBMER_COUNT = 6;    //로또 생성 및 당천번호 갯수

    private CommonLottoCheck() {

    }

    public static void CheckNumber(List<Integer> lottoNumbers) {
        isNumberCount(lottoNumbers);
        isSameValueCheck(lottoNumbers);

        for (Integer number : lottoNumbers) {
            checkLowStandardNumber(number);
        }
    }

    private static void isNumberCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUBMER_COUNT) {
            throw new RuntimeException(LottoErrorMessage.getLottoIncorrectCount());
        }
    }

    private static void isSameValueCheck(List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            for (int j = i + 1; j < lottoNumbers.size(); j++) {
                if (lottoNumbers.get(i) == lottoNumbers.get(j)) {
                    throw new RuntimeException(LottoErrorMessage.getLottoOverlapCheck());
                }
            }
        }
    }

    public static void checkLowStandardNumber(Integer paramValue) {
        if (paramValue > HIGH_STANDARD_NUMBER || paramValue < LOW_STANDARD_NUMBER) {
            throw new RuntimeException(LottoErrorMessage.getLottoRuntimeexception());
        }
    }
}
