package lottery.domain;

public class WinningTicket {

    private LotteryTicket winningNumbersTicket;

    private LotteryNumber bonusNumber;

    public WinningTicket(LotteryTicket ticket, LotteryNumber bonusNumber) {
        this.winningNumbersTicket = ticket;
        this.bonusNumber = bonusNumber;
    }

    public LotteryRank raffle(LotteryTicket ticket) {
        return LotteryRank.generate(winningNumbersTicket.countMatchNumbers(ticket),
                ticket.contains(bonusNumber));
    }
}
