package lottery.domain;

import java.util.List;

public class WinningTicket {

    private LotteryTicket winningNumbersTicket;

    private LotteryNumber bonusNumber;

    public WinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbersTicket = new LotteryTicket(winningNumbers);
        this.bonusNumber = LotteryNumber.of(bonusNumber);
    }

    public LotteryRank raffle(LotteryTicket ticket) {
        return LotteryRank.generate(winningNumbersTicket.countMatchNumbers(ticket),
                ticket.contains(bonusNumber));
    }
}
