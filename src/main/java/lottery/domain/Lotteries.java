package lottery.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotteries {
    public static List<Lottery> buy(Integer price, LotteryStrategy lotteryStrategy) {
        int number = calculateNumberOfLottery(price);
        List<Lottery> lotteries = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lotteries.add(lotteryStrategy.generate());
        }
        return lotteries;
    }

    private static int calculateNumberOfLottery(Integer price) {
        return price / LotteryPrice.VALUE;
    }

    public static LotteryResult calculateResult(List<Lottery> lotteries, Lottery winLottery) {
        List<Integer> numberOfMatchNumbers = lotteries.stream().map((lottery) -> calculateMatchCount(lottery, winLottery)).collect(Collectors.toList());
        List<Integer> winLotteryNumbers = new ArrayList<>();
        for (int i = 0; i <= Lottery.LENGTH; i++) {
            winLotteryNumbers.add(0);
        }
        for (int number : numberOfMatchNumbers) {
            winLotteryNumbers.set(number, winLotteryNumbers.get(number) + 1);
        }
        return new LotteryResult(winLotteryNumbers, lotteries.size());
    }

    private static int calculateMatchCount(Lottery lottery, Lottery winLottery) {
        List<LotteryNumber> lotteryNumbers = lottery.numbers();
        List<LotteryNumber> winLotteryNumbers = winLottery.numbers();

        return (int) lotteryNumbers.stream()
                .filter(winLotteryNumbers::contains)
                .count();
    }
}
