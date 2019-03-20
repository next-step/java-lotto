package lottery.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {

    public static final int NUMBERS_COUNT = 6;

    private List<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<Integer> numbers) {
        if (NUMBERS_COUNT != numbers.size()) {
            throw new IllegalArgumentException();
        }
        this.lotteryNumbers = numbers.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    public LotteryRank getWinningRank(LotteryTicket winningTicket) {
        return LotteryRank.generate(countWinningNumbers(winningTicket));
    }

    private int countWinningNumbers(LotteryTicket ticket) {
        return (int) lotteryNumbers.stream()
                .filter(lotteryNumber -> ticket.lotteryNumbers.contains(lotteryNumber))
                .count();
    }

    @Override
    public String toString() {
        return lotteryNumbers.toString();
    }
}
