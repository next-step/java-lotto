package lotto.view;

import lotto.domain.LottoCount;
import lotto.domain.Price;


public class InputInfo {

    private static final String MESSAGE_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    private final LottoCount manualCount;
    private final LottoCount autoCount;

    public InputInfo(Price price, LottoCount manualCount) {
        this.autoCount = price.calculatorLottoCount(manualCount);
        this.manualCount = manualCount;
    }

    public void printInfo() {
        System.out.println(String.format(MESSAGE_LOTTO_COUNT, manualCount.getCount(), autoCount.getCount()));
    }

    public LottoCount getManualCount() {
        return manualCount;
    }

    public LottoCount getAutoCount() {
        return autoCount;
    }
}
