package step2.domain;

import step2.domain.impl.AutoPurchase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseList {

    private static final PurchaseStrategy AUTO_PURCHASE = new AutoPurchase();

    private final List<Lotto> values;

    public PurchaseList(PurchaseCount purchaseCount) {
        this(purchaseCount.getValue());
    }

    public PurchaseList(int purchaseCount) {
        this(purchaseCount, AUTO_PURCHASE);
    }

    public PurchaseList(int purchaseCount, PurchaseStrategy purchaseStrategy) {
        this.values = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            values.add(new Lotto(purchaseStrategy));
        }
    }

    public List<Lotto> getValues() {
        return this.values;
    }

    public List<Long> calculateHitCount(Winner winner) {
        return values.stream()
                .map(lotto -> lotto.calculateHitCount(winner))
                .collect(Collectors.toList());
    }
}
