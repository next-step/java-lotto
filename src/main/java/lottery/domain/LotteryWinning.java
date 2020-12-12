package lottery.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class LotteryWinning {
    private final LotteryTicket winningTicket;
    private LotteryResult lotteryResult;

    public LotteryWinning(String winningNumbers) {
        this.winningTicket = new LotteryTicket(winningNumbers);
        lotteryResult = new LotteryResult();
    }

    public int getCountsMatched(LotteryTicket otherLotteryTicket) {
        int matchCount = 0;
        for(LotteryNumber number : otherLotteryTicket.getLotteryNumbers()) {
            matchCount += winningTicket.getLotteryNumbers().contains(number) ? 1 : 0;
        }
        return matchCount;
    }

    public LotteryResult getLotteryResult(List<LotteryTicket> lotteryTickets) {
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            lotteryResult.updateLotteryResult(this.getCountsMatched(lotteryTicket));
        }
        return lotteryResult;
    }

    public BigDecimal getProfit(int purchaseAmount) {
        return lotteryResult.getProfit(purchaseAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryWinning that = (LotteryWinning) o;
        return Objects.equals(winningTicket, that.winningTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningTicket);
    }
}
