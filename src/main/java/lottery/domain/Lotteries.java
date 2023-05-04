package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotteries {
    public static final int MAX_LOTTERY_NUMBER = 45;
    public static final int MIN_LOTTERY_NUMBER = 1;
    public static final int LOTTERY_PRICE = 1000;
    public static final int LOTTERY_LENGTH = 6;
    private static final int MATCHED = 1;
    private static final int NOT_MATCHED = 0;

    public static List<Lottery> buy(Integer price, LotteryStrategy lotteryStrategy) {
        int number = calculateNumberOfLottery(price);
        List<Lottery> lotteries = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lotteries.add(lotteryStrategy.generate());
        }
        return lotteries;
    }

    private static int calculateNumberOfLottery(Integer price) {
        return price / LOTTERY_PRICE;
    }

    public static LotteryResult calculateResult(List<Lottery> lotteries, Lottery winLottery) {
        List<Integer> numberOfMatchNumbers = lotteries.stream().map((lottery) -> calculateMatchCount(lottery, winLottery)).collect(Collectors.toList());
        List<Integer> winLotteryNumbers = new ArrayList<>();
        for (int i = 0; i <= Lotteries.LOTTERY_LENGTH; i++) {
            winLotteryNumbers.add(0);
        }
        for (int number : numberOfMatchNumbers) {
            winLotteryNumbers.set(number, winLotteryNumbers.get(number) + 1);
        }
        return new LotteryResult(winLotteryNumbers, lotteries.size());
    }

    private static int calculateMatchCount(Lottery lottery, Lottery winLottery) {
        int count = 0;
        List<Integer> lotteryNumbers = lottery.numbers();
        List<Integer> winLotteryNumbers = winLottery.numbers();

        for (int lotteryNumber : lotteryNumbers) {
            count += calculateMatchCount(winLotteryNumbers, lotteryNumber);
        }

        return count;
    }

    private static int calculateMatchCount(List<Integer> winLotteryNumbers, int lotteryNumber) {
        if (winLotteryNumbers.contains(lotteryNumber)) {
            return MATCHED;
        }
        return NOT_MATCHED;
    }
}
