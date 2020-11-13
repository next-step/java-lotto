package step2.domain;

public class WinningNumber {
    private final LotteryNumber winningNumber;

    public WinningNumber(LotteryNumber lotteryNumber) {
        if (lotteryNumber == null) {
            throw new IllegalStateException();
        }
        this.winningNumber = lotteryNumber;
    }

    public LotteryResult match(LotteryTickets tickets) {
        LotteryResult lotteryResult = new LotteryResult();
        for (LotteryNumber ticketNumber : tickets.listTicketNumbers()) {
            lotteryResult.add(ticketNumber.getMatched(winningNumber));
        }

        return lotteryResult;
    }
}
