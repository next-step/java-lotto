package step2.domain;

import java.util.List;

public class LotteryResult {

    private List<Integer> winningNumbers;

    public LotteryResult(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public long countMatchingNum(final LotteryTicket lotteryTicket) {
        return lotteryTicket.getLotteryTicketNumbers()
                .stream()
                .filter(winningNumber -> this.winningNumbers.contains(winningNumber))
                .count();
    }
}
