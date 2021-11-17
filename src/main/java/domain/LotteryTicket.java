package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {
    private static final String COMMA_AND_SPACING = ", ";
    private final List<Number> lotteryTicket;

    public LotteryTicket(List<Integer> lotteryTicket) {
        this.lotteryTicket = changeToLotteryNumber(lotteryTicket);
    }

    public static List<Number> changeToLotteryNumber(List<Integer> lotteryTicket) {
        return lotteryTicket.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public String lotteryNumber() {
        return lotteryTicket.stream()
                .map(number -> Integer.toString(number.value()))
                .collect(Collectors.joining(COMMA_AND_SPACING));
    }

    public int matchCount(LastWeekLotteryNumber lastWeekLottery) {
        int count = 0;
        for (Number number : lotteryTicket) {
            count += lastWeekLottery.lotteryMatch(number.value());
        }

        return count;
    }

    public int size() {
        return lotteryTicket.size();
    }

}
