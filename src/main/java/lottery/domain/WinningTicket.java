package lottery.domain;

import java.util.List;

public class WinningTicket {

    private LotteryTicket winningTicket;

    private LotteryNumber bonusNumber;

    public WinningTicket(List<Integer> winningNumbers, int bonusNumber) {
        this.bonusNumber = new LotteryNumber(bonusNumber);
        this.winningTicket = new LotteryTicket(winningNumbers);
    }

    public LotteryRank raffle(LotteryTicket ticket) {
        final int count = (int) winningTicket.lotteryNumbers
                .stream()
                .filter(winningNumber -> ticket.lotteryNumbers.contains(winningNumber))
                .count();

        final boolean matchBonus = ticket.lotteryNumbers.contains(bonusNumber);

        return LotteryRank.generate(count, matchBonus);
    }
}
