package step2.domain;

import step2.Rank;

public class WinningNumber {
    private final LotteryNumber winningNumber;
    private final Integer bonusNumber;

    public WinningNumber(LotteryNumber lotteryNumber, Integer bonusNumber) {
        ensureNotNull(lotteryNumber, bonusNumber);
        this.winningNumber = lotteryNumber;
        this.bonusNumber = bonusNumber;
    }

    public MatchResult match(LotteryTickets tickets) {
        MatchResult matchResult = new MatchResult();
        for (LotteryNumber ticketNumber : tickets.getTicketNumbers()) {
            matchResult.add(toRank(ticketNumber));
        }

        return matchResult;
    }

    private void ensureNotNull(LotteryNumber lotteryNumber, Integer bonusNumber) {
        if (lotteryNumber == null || bonusNumber == null) {
            throw new IllegalStateException();
        }
    }

    private Rank toRank(LotteryNumber lotteryNumber) {
        if (hasBonusNumber(lotteryNumber)) {
            return RankFactory.valueWithBonusNumberFrom(lotteryNumber.getMatched(winningNumber));
        }
        return RankFactory.valueFrom(lotteryNumber.getMatched(winningNumber));
    }

    private boolean hasBonusNumber(LotteryNumber lotteryNumber) {
        return lotteryNumber.contains(bonusNumber);
    }
}
