package lotto.domain.dto;

import lotto.domain.Money;
import lotto.domain.RankResult;

public class RankDTO {

    private final RankResult rankResult;
    private final Money purchaseAmount;

    public RankDTO(RankResult rankResult, Money purchaseAmount) {
        this.rankResult = rankResult;
        this.purchaseAmount = purchaseAmount;
    }

    public RankResult getRankResult() {
        return rankResult;
    }

    public Money getPurchaseAmount() {
        return purchaseAmount;
    }
}
