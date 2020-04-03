package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public class BuyerResult {
    private final List<Rank> winningResult;
    private final BigDecimal profitRate;

    public BuyerResult(List<Rank> ranks, int lottoCount) {
        this.winningResult = ranks;
        this.profitRate = calculateProfitRate(lottoCount);
    }

    private BigDecimal calculateProfitRate(int lottoCount) {
        Money totalReward = getTotalReward();
        return totalReward.calculateProfit(LottoTicket.TICKET_PRICE.multiply(lottoCount));
    }

    private Money getTotalReward() {
        return winningResult.stream()
                .map(Rank::getReward)
                .reduce(Money.ZERO(), Money::sum);

    }

    public List<Rank> getWinningResult() {
        return winningResult;
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }
}
