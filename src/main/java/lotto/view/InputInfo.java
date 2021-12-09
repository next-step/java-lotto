package lotto.view;

import lotto.domain.Number;
import lotto.exception.LottoNumberException;


public class InputInfo {

    private static final String MESSAGE_ERR_PRICE = "구매 금액을 확인하세요.";
    private static final String MESSAGE_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO_LOTTO = 0;

    private Number manualCount;
    private Number autoCount;

    public InputInfo(Number price, Number manualCount) {
        this.autoCount = calculatorLotto(price, manualCount);
        this.manualCount = manualCount;
    }

    public void printInfo() {
        System.out.println(String.format(MESSAGE_LOTTO_COUNT, manualCount.getNumber(), autoCount.getNumber()));
    }

    private Number calculatorLotto(Number price, Number manualCount) {
        int autoCount = (price.getNumber() / LOTTO_PRICE) - manualCount.getNumber();
        if (autoCount > ZERO_LOTTO) {
            return new Number(autoCount);
        }
        throw new LottoNumberException(MESSAGE_ERR_PRICE);
    }

    public Number getManualCount() {
        return manualCount;
    }

    public Number getAutoCount() {
        return autoCount;
    }
}
