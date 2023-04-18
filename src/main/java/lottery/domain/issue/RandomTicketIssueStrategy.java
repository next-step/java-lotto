package lottery.domain.issue;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomTicketIssueStrategy implements TicketIssueStrategy {
    private final List<Integer> allLotteryNumbers;

    public RandomTicketIssueStrategy(List<Integer> allLotteryNumbers) {
        this.allLotteryNumbers = allLotteryNumbers;
    }

    @Override
    public LotteryTicket issue() {
        Collections.shuffle(allLotteryNumbers);

        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (int i = 0; i < LotteryTicket.LOTTERY_TICKET_SIZE; i++) {
            lotteryNumbers.add(new LotteryNumber(allLotteryNumbers.get(i)));
        }

        return new LotteryTicket(lotteryNumbers);
    }
}
