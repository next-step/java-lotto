package lottery.strategy;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottery.domain.LotteryNumber.LOTTERY_MAX_NUMBER;
import static lottery.domain.LotteryNumber.LOTTERY_MIN_NUMBER;
import static lottery.domain.LotteryTicket.LOTTERY_TICKET_SIZE;

public class RandomTicketIssueStrategy implements TicketIssueStrategy {
    private static final List<LotteryNumber> allLotteryNumbers =
            IntStream.range(LOTTERY_MIN_NUMBER, LOTTERY_MAX_NUMBER + 1)
                    .mapToObj(LotteryNumber::new)
                    .collect(Collectors.toList());

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
