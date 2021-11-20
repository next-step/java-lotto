package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {
    private final List<LotteryNumber> lotteryTicket;

    public LotteryTicket(List<Integer> lotteryTicket) {
        this.lotteryTicket = Collections.unmodifiableList(changeToLotteryNumber(lotteryTicket));
    }

    public static List<LotteryNumber> changeToLotteryNumber(List<Integer> lotteryTicket) {
        return lotteryTicket.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    public int getLotteryNumber(int index){
        return lotteryTicket.get(index).value();
    }

    public int matchCount(LastWeekLotteryNumber lastWeekLottery) {
        int count = 0;
        for (LotteryNumber number : lotteryTicket) {
            count += lastWeekLottery.matchNumber(number.value());
        }

        return count;
    }

    public int size() {
        return lotteryTicket.size();
    }

}
