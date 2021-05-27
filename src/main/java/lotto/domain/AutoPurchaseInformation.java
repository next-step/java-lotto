package lotto.domain;

/**
 * 자동 로또 구매 정보
 */
public class AutoPurchaseInformation extends PurchaseInformation {

    public AutoPurchaseInformation(final int allLottoCount, final int manualCount) {
        super(allLottoCount, manualCount);
    }

    @Override
    public int getLottoCount() {
        return super.getAllLottoCount() - super.getManualCount();
    }
}
