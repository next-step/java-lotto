package lottery.strategy;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;

import java.util.ArrayList;
import java.util.List;

import static lottery.domain.LotteryTicket.LOTTERY_TICKET_SIZE;

public class ManualTicketIssueStrategy implements TicketIssueStrategy {
    private final List<Integer> manualNumbers;

    public ManualTicketIssueStrategy(List<Integer> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    @Override
    public LotteryTicket issue() {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTERY_TICKET_SIZE; i++) {
            lotteryNumbers.add(new LotteryNumber(manualNumbers.get(i)));
        }
        return new LotteryTicket(lotteryNumbers);
    }
}
