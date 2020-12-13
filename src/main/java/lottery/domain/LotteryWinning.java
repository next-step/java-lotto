package lottery.domain;

import java.util.List;
import java.util.Objects;

public class LotteryWinning {
    private final LotteryTicket winningTicket;
    private final LotteryNumber bonusNumber;
    private LotteryResult lotteryResult;

    public LotteryWinning(String winningNumbers, String bonusNumber) {
        this.winningTicket = new LotteryTicket(winningNumbers);
        this.bonusNumber = new LotteryNumber(Integer.parseInt(bonusNumber));
        lotteryResult = new LotteryResult();
    }

    public int getCountsMatched(LotteryTicket otherLotteryTicket) {
        //TODO : winningTicket.getLotteryNumbers().contains(number)에서 contains는 winingTicket으로 구현하는 방향으로 개선 필요
        int matchCount = 0;
        for(LotteryNumber number : otherLotteryTicket.getLotteryNumbers()) {
            matchCount += winningTicket.getLotteryNumbers().contains(number) ? 1 : 0;
        }
        return matchCount;
    }

    public boolean isMatchedBonusNumber(LotteryTicket lotteryTicket) {
        if (lotteryTicket.getLotteryNumbers().contains(this.bonusNumber)) {
            return true;
        }
        return false;
    }

    public LotteryResult getLotteryResult(List<LotteryTicket> lotteryTickets) {
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            lotteryResult.updateLotteryResult(
                    this.getCountsMatched(lotteryTicket),
                    isMatchedBonusNumber(lotteryTicket));
        }
        return lotteryResult;
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
