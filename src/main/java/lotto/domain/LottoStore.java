package lotto.domain;

public class LottoStore {
    private static final int LOTTO_UNIT_PRICE = 1000;
    private LottoMachine lottoMachine;

    public LottoStore() {
        this.lottoMachine = new LottoMachine();
    }

    public PurchaseResult purchaseLottos(Money money, ManualLottoOrderSheet manualLottoOrderSheet) {
        validatePurchasableManualLotto(money, manualLottoOrderSheet);
        Lottos manualLottos = lottoMachine.purchaseManualLottos(manualLottoOrderSheet);
        Lottos automaticLottos = lottoMachine.purchaseAutomaticLottos(getPurchaseAutomaticLottoCount(money, manualLottos.getLottoCount()));

        return new PurchaseResult(manualLottos, automaticLottos);
    }

    private int getPurchaseAutomaticLottoCount(Money money, int manualLottoCount) {
        int manualLottoTotalPrice = getTotalPrice(manualLottoCount);
        return getPurchasableCount(money.leftMoney(manualLottoTotalPrice));
    }

    private void validatePurchasableManualLotto(Money money, ManualLottoOrderSheet manualLottoOrderSheet) {
        int leftMoney = money.getMoney() - getTotalPrice(manualLottoOrderSheet.getOrderCount());
        if (leftMoney < 0) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
    }

    private int getTotalPrice(int purchaseCount) {
        return LOTTO_UNIT_PRICE * purchaseCount;
    }

    private int getPurchasableCount(int money) {
        return money / LOTTO_UNIT_PRICE;
    }
}
