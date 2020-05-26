package lotto.domain;

import java.util.List;

public class LottoPurchaseInformation {
    private int manualCount;
    private int purchasePrice;
    private List<Lotto> manualNumbers;

    public LottoPurchaseInformation(int manualCount, int purchasePrice) {
        this.manualCount = manualCount;
        this.purchasePrice = purchasePrice;
        // 
    }
}
