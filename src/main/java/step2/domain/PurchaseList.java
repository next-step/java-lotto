package step2.domain;

import step2.domain.impl.AutoPurchase;

import java.util.ArrayList;
import java.util.List;

public class PurchaseList {

    private static final PurchaseStrategy AUTO_PURCHASE = new AutoPurchase();

    private final List<Lotto> values;

    public PurchaseList(PurchaseCount purchaseCount) {
        this(purchaseCount.getValue());
    }

    public PurchaseList(int purchaseCount) {
        this.values = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            values.add(new Lotto(AUTO_PURCHASE));
        }
    }
}
