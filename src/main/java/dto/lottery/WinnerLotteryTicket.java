package dto.lottery;

public class WinnerLotteryTicket {
    private final LotteryTicket winnerLotteryTicket;
    private final int bonusTicketNumber;

    public WinnerLotteryTicket(LotteryTicket winnerTicket, int bonusTicketNumber) {
        this.winnerLotteryTicket = winnerTicket;
        this.bonusTicketNumber = bonusTicketNumber;
    }

    public LotteryTicket getWinnerLotteryTicket() {
        return winnerLotteryTicket;
    }

    public int getBonusTicketNumber() {
        return bonusTicketNumber;
    }
}
