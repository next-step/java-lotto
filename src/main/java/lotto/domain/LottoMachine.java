package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public LottoMachine() {
    }

    public PurchaseResult purchaseManualLottos(Money money, ManualLottoOrderSheet manualLottoOrderSheet) {
        validatePurchasableCount(money, manualLottoOrderSheet);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < manualLottoOrderSheet.getOrderCount(); i++) {
            lottos.add(Lotto.manual(manualLottoOrderSheet.getManualLottoOrders().get(i)));
        }
        return new PurchaseResult(lottos, new Money(manualLottoOrderSheet.getOrderCount() * LOTTO_PRICE));
    }

    public PurchaseResult purchaseAutomaticLottos(Money money) {
        int purchasableCount = getAutomaticPurchasableCount(money);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchasableCount; i++) {
            lottos.add(Lotto.automatic());
        }
        return new PurchaseResult(lottos, new Money(purchasableCount * LOTTO_PRICE));
    }

    private void validatePurchasableCount(Money money, ManualLottoOrderSheet manualLottoOrderSheet) {
        int laftMoney = money.getMoney() - (LOTTO_PRICE * manualLottoOrderSheet.getOrderCount());
        if (laftMoney < 0) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
    }

    private int getAutomaticPurchasableCount(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}
