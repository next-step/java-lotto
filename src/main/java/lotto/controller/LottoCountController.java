package lotto.controller;

import lotto.domain.LottoCount;

public class LottoCountController {
    private static final int PRICE_PER_LOTTO = 1000;
    private final LottoCount totalCount;
    private final LottoCount manualCount;

    public LottoCountController(String price, String manualCount) {
        this(new LottoCount(price, PRICE_PER_LOTTO), new LottoCount(manualCount));
    }

    public LottoCountController(LottoCount totalCount, LottoCount manualCount) {
        if (!validateLottoCount(totalCount, manualCount)) {
            throw new RuntimeException("유효하지 않은 입력입니다");
        }

        this.totalCount = totalCount;
        this.manualCount = manualCount;
    }

    private static boolean validateLottoCount(LottoCount total, LottoCount manual) {
        return total.isBiggerOrSameThan(manual);
    }

    public LottoCount getAutoCount() {
        return totalCount.diff(manualCount);
    }

    public LottoCount getManualCount() {
        return new LottoCount(manualCount);
    }
}
