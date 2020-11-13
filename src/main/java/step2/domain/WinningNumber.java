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
            lotteryResult.add(ticketNumber.getMatched(winningNumber));
        }

        return lotteryResult;
    }
}
