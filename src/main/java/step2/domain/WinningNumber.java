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
            lotteryResult.add(toRank(ticketNumber.getMatched(winningNumber), ticketNumber));
        }

        return lotteryResult;
    }

    private Rank toRank(int matched, LotteryNumber lotteryNumber) {
        if (matched == 5 && hasBonusNumber(lotteryNumber)) {
            return Rank.SECOND;
        }
        if (matched == 5) {
            return Rank.THIRD;
        }
        return Rank.valueFrom(matched);
    }

    private boolean hasBonusNumber(LotteryNumber lotteryNumber) {
        return lotteryNumber.contains(bonusNumber);
    }
}
