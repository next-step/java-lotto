package step5.lotto;

import step5.utils.ValidationUtils;

public class LottoCount {
    private static final int DEFAULT_PRICE = 1000;

    private final int lottoCount;
    private final int lottoManualCount;

    public LottoCount(int price, int manualCount) {
        ValidationUtils.validPurchasePrice(price);
        this.lottoCount = calculatePriceToCount(price);

        ValidationUtils.validManualCount(this.lottoCount, manualCount);
        this.lottoManualCount = manualCount;
    }

    public int calculatePriceToCount(int price) {
        return price / DEFAULT_PRICE;
    }

    public int calculateCountToPrice() {
        return this.lottoCount * DEFAULT_PRICE;
    }

    public int manualLottoCount() {
        return this.lottoManualCount;
    }

    public boolean isLottoManualCountZero() {
        if (this.manualLottoCount() == 0) {
            return true;
        }
        return false;
    }

    public int autoLottoCount() {
        return lottoCount - lottoManualCount;
    }
}
