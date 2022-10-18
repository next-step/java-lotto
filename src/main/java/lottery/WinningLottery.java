package lottery;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottery extends Lottery {
    public WinningLottery(List<LotteryNumber> lotteryNumbers) {
        super(lotteryNumbers);
    }

    public LotteryResult createLotteryResult(List<Lottery> lotteries) {
        return new LotteryResult(countEqualNumbers(lotteries), lotteries.size(), LotteryCompany.LOTTERY_PRICE);
    }

    private EnumMap<LotteryRank, Integer> countEqualNumbers(List<Lottery> lotteries) {
        return new EnumMap<>(lotteries.stream()
                .map(this::countEqualNumbers)
                .filter(LotteryRank::isUsedRank)
                .collect(Collectors.toMap(LotteryRank::getInstanceOfRank, value -> 1,
                        (existing, replacement) -> existing + 1)));
    }

    private int countEqualNumbers(Lottery lottery) {
        return this.lotteryNumbers.stream()
                .filter(lottery.lotteryNumbers::contains)
                .mapToInt(lotteryNumber -> 1)
                .sum();
    }

}
