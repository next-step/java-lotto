package lottos.domain;

import java.util.Collections;
import java.util.List;

public class Statistics {

    private Integer purchaseAmount;
    private List<Result> results;

    public Statistics(int purchaseAmount, List<Result> results) {
        this.purchaseAmount = purchaseAmount;
        this.results = results;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Result> getLottoResults() {
        return Collections.unmodifiableList(results);
    }
}
