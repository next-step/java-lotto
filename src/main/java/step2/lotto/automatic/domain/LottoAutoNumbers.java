package step2.lotto.automatic.domain;

import step2.lotto.automatic.util.LottoStep2ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 로또 자동생성
 */
public class LottoAutoNumbers {

    private List<Integer> basicLottoNumbers = new ArrayList<>();
    private static final int MAKE_LOTTO_NUMBERS_COUNT = 45;  // 로또 생성 갯수

    public LottoAutoNumbers(int makeLottoNumberCount) {
        isNumberNegative(makeLottoNumberCount);
        isMakeCount(makeLottoNumberCount);

        for (int i = 0; i < makeLottoNumberCount; i++) {
            basicLottoNumbers.add(i);
        }
    }

    public List<Integer> getAutoNumbers(int getLottoAutoNumberCount) {
        List<Integer> returnList = new ArrayList<>();
        isNumberNegative(getLottoAutoNumberCount);

        Collections.shuffle(basicLottoNumbers);

        for (int i = 0; i < getLottoAutoNumberCount; i++) {
            returnList.add(basicLottoNumbers.get(i));
        }

        return returnList;
    }

    private void isNumberNegative(int paramValue) {
        if (paramValue <= 0) {
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2Negativeexception());
        }
    }

    private void isMakeCount(int paramValue) {
        if (MAKE_LOTTO_NUMBERS_COUNT != paramValue) {
            throw new RuntimeException(LottoStep2ErrorMessage.getLottoStep2MakeCountCheck());
        }
    }
}
