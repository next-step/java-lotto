package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoBuyBehavior implements BuyBehavior {
    public static final int END_INCLUSIVE = 45;
    public static final int START_INCLUSIVE = 1;
    public static final int FROM_INDEX = 0;

    @Override
    public List<LotteryTicket> buyLotteryTickets(int pickCounts, int numberOfTickets) {
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        LotteryTicket lotteryTicket;
        for(int i = 0; i < numberOfTickets; i++) {
            lotteryTicket = new LotteryTicket(getLotteryNumbersByAutomation(pickCounts));
            lotteryTickets.add(lotteryTicket);
        }
        return lotteryTickets;
    }

    private List<LotteryNumber> getLotteryNumbersByAutomation(int pickCounts) {
        List<Integer> lotteryAllNumbers = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lotteryAllNumbers);
        return createLotteryNumbersByNumbers(lotteryAllNumbers.subList(FROM_INDEX, pickCounts));
    }

    private List<LotteryNumber> createLotteryNumbersByNumbers(List<Integer> numbers) {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>();
        LotteryNumber lotteryNumber;
        for(Integer integer : numbers) {
            lotteryNumber = new LotteryNumber(integer.intValue());
            lotteryNumbers.add(lotteryNumber);
        }
        return lotteryNumbers;
    }
}
