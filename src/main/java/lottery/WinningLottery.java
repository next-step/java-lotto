package lottery;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningLottery extends Lottery {

    private final LotteryNumber bonusLotteryNumber;

    public WinningLottery(List<LotteryNumber> lotteryNumbers, LotteryNumber bonusLotteryNumber) {
        super(lotteryNumbers);

        validate(bonusLotteryNumber);
        this.bonusLotteryNumber = bonusLotteryNumber;
    }

    private void validate(LotteryNumber bonusLotteryNumber) {
        if (lotteryNumbers.contains(bonusLotteryNumber)) {
            throw new IllegalArgumentException(LOTTERY_NUM_DUPLICATED_ERR_MSG);
        }
    }

    public LotteryResult createLotteryResult(List<Lottery> lotteries) {
        return new LotteryResult(countEqualNumbers(lotteries), LotteryCompany.LOTTERY_PRICE);
    }

    private EnumMap<LotteryRank, Integer> countEqualNumbers(List<Lottery> lotteries) {
        return new EnumMap<>(lotteries.stream()
                .map(lottery -> LotteryRank.valueOf(countEqualNumbers(lottery)))
                .collect(Collectors.toMap(Function.identity(), value -> 1,
                        (existing, replacement) -> existing + 1)));
    }

    private int countEqualNumbers(Lottery lottery) {
        return this.lotteryNumbers.stream()
                .filter(lottery.lotteryNumbers::contains)
                .mapToInt(lotteryNumber -> 1)
                .sum();
    }

}
