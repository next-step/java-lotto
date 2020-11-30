package step4.lotto.domain.numbers;

import step4.lotto.util.LottoErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 로또 자동생성
 */
public class LottoMachine {
    private static List<Integer> basicLottoNumbers = new ArrayList<>();
    private static LottoAutoNumber lottoAutoNumbers;
    private static LottoManualNumber lottoManualNumber;

    public LottoMachine() {
        lottoAutoNumbers = new LottoAutoNumber();
    }

    public LottoTicket getAutoNumbers(int getLottoAutoNumberCount) {
        isNumberNegative(getLottoAutoNumberCount);

        return lottoAutoNumbers.getAutoNumbers(getLottoAutoNumberCount);
    }

    public Set<LottoTicket> getManualNumbers(List<String> manualNumber, int buyCount) {
        isNumberNegative(buyCount);

        lottoManualNumber = new LottoManualNumber(manualNumber, buyCount);

        return lottoManualNumber.getManualLottoSet();
    }

    private void isNumberNegative(int paramValue) {
        if (paramValue <= 0) {
            throw new RuntimeException(LottoErrorMessage.getLottoNegativeexception());
        }
    }
}
