package lotto.domain;

/**
 * 수동 로또 구매 정보
 */
public class ManualPurchaseInformation extends PurchaseInformation {

    public ManualPurchaseInformation(final int allLottoCount, final int manualCount) {
        super(allLottoCount, manualCount);
    }

    @Override
    public int getLottoCount() {
        return super.getManualCount();
    }
}
