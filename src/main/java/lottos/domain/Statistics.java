package lottos.domain;

import java.util.Collections;
import java.util.List;

public class Statistics {

    private Integer purchaseAmount;
    private List<LottoResult> lottoResults;

    public Statistics(int purchaseAmount, List<LottoResult> lottoResults) {
        this.purchaseAmount = purchaseAmount;
        this.lottoResults = lottoResults;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<LottoResult> getLottoResults() {
        return Collections.unmodifiableList(lottoResults);
    }
}
