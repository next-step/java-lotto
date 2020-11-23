package step2.lotto.automatic.domain.numbers;

import step2.lotto.automatic.domain.numbers.LottoAutoNumbers;
import step2.lotto.automatic.util.LottoStep2ErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 자동생성
 */
public class LottoMachine {

    private static final int MAKE_LOTTO_NUMBERS_COUNT = 45;  // 로또 생성 갯수

    private static List<Integer> basicLottoNumbers = new ArrayList<>();

    private static LottoAutoNumbers lottoAutoNumbers;

    public LottoMachine(int makeLottoNumberCount) {
        isNumberNegative(makeLottoNumberCount);
        isMakeCount(makeLottoNumberCount);
        lottoAutoNumbers = new LottoAutoNumbers(makeLottoNumberCount);
    }

    public List<Integer> getAutoNumbers(int getLottoAutoNumberCount) {
        isNumberNegative(getLottoAutoNumberCount);

        return lottoAutoNumbers.getAutoNumbers(getLottoAutoNumberCount);
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
