package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    public static final int MAX_LOTTERY_NUMBER = 45;
    public static final int MIN_LOTTERY_NUMBER = 1;
    public static final int LOTTERY_PRICE = 1000;

    public static List<Lottery> buy(Integer price, LotteryStrategy lotteryStrategy) {
        return new ArrayList<>();
    }

    public static LotteryResult calculateResult(List<Lottery> lotteries, Lottery winLottery) {
        return new LotteryResult(new ArrayList<>());
    }
}
