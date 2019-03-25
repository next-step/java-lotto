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
        final int matchCount = (int) winningNumbersTicket.lotteryNumbers
                .stream()
                .filter(winningNumber -> ticket.lotteryNumbers.contains(winningNumber))
                .count();

        return LotteryRank.generate(matchCount, ticket.lotteryNumbers.contains(bonusNumber));
    }
}
