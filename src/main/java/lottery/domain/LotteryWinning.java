package lottery.domain;

import java.util.Objects;

public class LotteryWinning {
    private final LotteryTicket winningTicket;
    private final LotteryNumber bonusNumber;

    public LotteryWinning(String winningNumbers, String bonusNumber) {
        this.winningTicket = LotteryTicket.of(winningNumbers);
        this.bonusNumber = LotteryNumber.of(bonusNumber);
    }

    public int getCountsMatched(LotteryTicket otherLotteryTicket) {
        int matchCount = 0;
        for(LotteryNumber number : otherLotteryTicket.getLotteryNumbers()) {
            matchCount = countMatchedNumbers(matchCount, number);
        }
        return matchCount;
    }

    private int countMatchedNumbers(int matchCount, LotteryNumber number) {
        if (winningTicket.contains(number)) {
            matchCount += 1;
        }
        return matchCount;
    }

    public boolean isMatchedBonusNumber(LotteryTicket lotteryTicket) {
        return lotteryTicket.contains(this.bonusNumber);
    }

    public LotteryResult getLotteryResult(LotteryTickets lotteryTickets) {
        LotteryResult lotteryResult = new LotteryResult();
        for (LotteryTicket lotteryTicket : lotteryTickets.getLotteryTickets()) {
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
