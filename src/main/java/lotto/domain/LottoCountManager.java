package lotto.domain;

import lotto.utils.ValidationCheck;

public class LottoCountManager {

    private int budget;
    private int manualCount;

    public LottoCountManager(int budget, int manualCount) {
        this.budget = budget;
        this.manualCount = manualCount;
        if (ValidationCheck.isResonableManualCount()) {
            throw new ValidationException();
        }
    }
}
