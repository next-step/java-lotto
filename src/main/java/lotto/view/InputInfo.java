package lotto.view;

import lotto.domain.Number;
import lotto.domain.Price;


public class InputInfo {

    private static final String MESSAGE_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    private final Number manualCount;
    private final Number autoCount;

    public InputInfo(Price price, Number manualCount) {
        this.autoCount = price.calculatorLotto(manualCount);
        this.manualCount = manualCount;
    }

    public void printInfo() {
        System.out.println(String.format(MESSAGE_LOTTO_COUNT, manualCount.getNumber(), autoCount.getNumber()));
    }

    public Number getManualCount() {
        return manualCount;
    }

    public Number getAutoCount() {
        return autoCount;
    }
}
