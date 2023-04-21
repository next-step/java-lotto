package lottery.strategy;

import lottery.Constant;
import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;

import java.util.ArrayList;
import java.util.List;

public class ManualTicketIssueStrategy implements TicketIssueStrategy {
    private final List<Integer> manualNumbers;

    public ManualTicketIssueStrategy(List<Integer> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    @Override
    public LotteryTicket issue() {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (int i = 0; i < Constant.LOTTERY_TICKET_SIZE; i++) {
            lotteryNumbers.add(new LotteryNumber(manualNumbers.get(i)));
        }
        return new LotteryTicket(lotteryNumbers);
    }
}
