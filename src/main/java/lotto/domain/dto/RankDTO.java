package lotto.domain.dto;

import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.RankResult;

public class RankDTO {

    private final RankResult rankResult;
    private final Prize purchaseAmount;

    public RankDTO(RankResult rankResult, Prize purchaseAmount) {
        this.rankResult = rankResult;
        this.purchaseAmount = purchaseAmount;
    }

    public RankResult getRankResult() {
        return rankResult;
    }

    public Money getPrizeValue() {
        return purchaseAmount.getValue();
    }
}
