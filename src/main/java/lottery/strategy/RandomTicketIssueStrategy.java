package lottery.strategy;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lottery.Constant.*;

public class RandomTicketIssueStrategy implements TicketIssueStrategy {
    private static final List<LotteryNumber> allLotteryNumbers;

    static {
        allLotteryNumbers = new ArrayList<>();
        for (int i = LOTTERY_MIN_NUMBER; i < LOTTERY_MAX_NUMBER; i++) {
            allLotteryNumbers.add(new LotteryNumber(i));
        }
    }

    private static List<LotteryNumber> selectLotteryNumbers() {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTERY_TICKET_SIZE; i++) {
            lotteryNumbers.add(allLotteryNumbers.get(i));
        }
        return lotteryNumbers;
    }

    private static void shuffle() {
        Collections.shuffle(allLotteryNumbers);
    }

    @Override
    public LotteryTicket issue() {
        shuffle();
        return new LotteryTicket(selectLotteryNumbers());
    }
}
