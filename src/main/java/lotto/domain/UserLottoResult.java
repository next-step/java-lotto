package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class UserLottoResult {
    private final Money ticketsPrice;
    private final List<LottoGameRank> ranks;

    public UserLottoResult(Money ticketPrice, List<LottoGameRank> ranks) {
        this.ticketsPrice = ticketPrice.times(ranks.size());
        this.ranks = ranks;
    }

    public int countRank(LottoGameRank target) {
        return (int)ranks.stream()
            .filter(rank -> rank == target)
            .count();
    }

    public BigDecimal calculateReturnRate() {
        if (ticketsPrice.equals(Money.ZERO)) {
            return BigDecimal.ZERO;
        }

        return new BigDecimal(getTotalReward().getValue()).divide(new BigDecimal(ticketsPrice.getValue()), 2, RoundingMode.HALF_UP);
    }

    private Money getTotalReward() {
        return ranks.stream()
            .map(LottoGameRank::getReward)
            .reduce(new Money(0), Money::plus);
    }
}
