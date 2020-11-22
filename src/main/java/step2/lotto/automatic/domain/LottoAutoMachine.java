package step2.lotto.automatic.domain;

import step2.lotto.automatic.util.LottoStep2ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 로또 자동생성
 */
public class LottoAutoMachine {

    private static List<Integer> basicLottoNumbers = new ArrayList<>();
    private static final int MAKE_LOTTO_NUMBERS_COUNT = 45;  // 로또 생성 갯수
    private static LottoAutoMachine lottoAutoNumbers;  // auto 번호 생성

    public LottoAutoMachine(int makeLottoNumberCount) {
        isNumberNegative(makeLottoNumberCount);
        isMakeCount(makeLottoNumberCount);
        initLottoNubmers(makeLottoNumberCount);
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

    private void initLottoNubmers(int initLottoNubmers) {
        for (int i = 1; i <= initLottoNubmers; i++) {
            basicLottoNumbers.add(i);
        }
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
