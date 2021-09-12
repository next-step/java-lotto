package step2.view;

import step2.domain.lotto.Lotto;
import step2.domain.statistics.Amount;

import java.util.List;

public class InputManual {
    private final Amount manualAmount;
    private final List<Lotto> manualLottoList;

    public InputManual(Amount amount, List<Lotto> manualLottoList) {
        this.manualAmount = amount;
        this.manualLottoList = manualLottoList;
    }

    public Amount getManualAmount() {
        return this.manualAmount;
    }
    public List<Lotto> getManualLottoList() {
        return this.manualLottoList;
    }
}
