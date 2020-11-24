package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.Collection;
import java.util.Map;

public class Lotto {
    private final Integer price;
    private final LottoConstraint constraint;
    private final PrizeInfo prizeInfo;

    public Lotto(Integer price, LottoConstraint constraint, PrizeInfo prizeInfo) {
        this.price = price;
        this.constraint = constraint;
        this.prizeInfo = prizeInfo;
    }

    public Integer getPrice() {
        return price;
    }

    public LottoConstraint getConstraint() {
        return constraint;
    }

    public Rank checkRank(Pick pick, Collection<Integer> winningBalls) {
        return this.prizeInfo.checkRank(pick, winningBalls);
    }

    public Map<Rank, Prize> getPrizeMap() {
        return prizeInfo.getPrizeMap();
    }
}
