package step2.domain;

public class WinningNumber {
    private final LotteryNumber winningNumber;
    private Integer bonusNumber;

    public WinningNumber(LotteryNumber lotteryNumber, Integer bonusNumber) {
        if (lotteryNumber == null) {
            throw new IllegalStateException();
        }
        this.winningNumber = lotteryNumber;
        this.bonusNumber = bonusNumber; // TODO not null
    }

    public WinningNumber(LotteryNumber lotteryNumber) {
        this(lotteryNumber, null);
    }

    public LotteryResult match(LotteryTickets tickets) {
        LotteryResult lotteryResult = new LotteryResult();
        for (LotteryNumber ticketNumber : tickets.listTicketNumbers()) {
            lotteryResult.add(toRank(ticketNumber));
        }

        return lotteryResult;
    }

    private Rank toRank(LotteryNumber lotteryNumber) {
        if (hasBonusNumber(lotteryNumber)) {
            return Rank.valueWithBonusNumberFrom(lotteryNumber.getMatched(winningNumber));
        }
        return Rank.valueFrom(lotteryNumber.getMatched(winningNumber));
    }

    private boolean hasBonusNumber(LotteryNumber lotteryNumber) {
        return lotteryNumber.contains(bonusNumber);
    }
}
