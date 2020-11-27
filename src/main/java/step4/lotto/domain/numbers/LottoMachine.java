package step4.lotto.domain.numbers;

import step4.lotto.util.LottoErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 자동생성
 */
public class LottoMachine {
    private static List<Integer> basicLottoNumbers = new ArrayList<>();
    private static LottoAutoNumbers lottoAutoNumbers;

    public LottoMachine() {
        lottoAutoNumbers = new LottoAutoNumbers();
    }

    public LottoTicket getAutoNumbers(int getLottoAutoNumberCount) {
        isNumberNegative(getLottoAutoNumberCount);

        return lottoAutoNumbers.getAutoNumbers(getLottoAutoNumberCount);
    }

    private void isNumberNegative(int paramValue) {
        if (paramValue <= 0) {
            throw new RuntimeException(LottoErrorMessage.getLottoNegativeexception());
        }
    }
}
