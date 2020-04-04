package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class BuyerResult {
    private final List<Rank> winningResult;

    public static BuyerResult of(List<Rank> winningResult) {
        return new BuyerResult(winningResult);
    }

    private BuyerResult(List<Rank> ranks) {
        this.winningResult = ranks;
    }

    public List<Rank> getWinningResult() {
        return winningResult;
    }

    public BigDecimal calculateProfitRate() {
        Money totalReward = getTotalReward();
        return totalReward.calculateProfit(LottoTicket.TICKET_PRICE
                .multiply(winningResult.size()));
    }

    private Money getTotalReward() {
        return winningResult.stream()
                .map(Rank::getReward)
                .reduce(Money.ZERO(), Money::sum);

    }

}
