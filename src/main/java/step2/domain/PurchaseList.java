package step2.domain;

import step2.domain.impl.AutoPurchase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseList {

    private static final PurchaseStrategy AUTO_PURCHASE = new AutoPurchase();

    private final List<Lotto> values;

    public PurchaseList(PurchaseMoney purchaseMoney) {
        this(purchaseMoney.calculatePurchaseCount());
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

    public List<LottoRank> calculateRankEach(WinningLotto winningLotto) {
        return values.stream()
                .map(winningLotto::calculateRank)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.values.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
