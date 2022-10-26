package lottery;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningLottery {

    private final Lottery winningLottery;
    private final LotteryNumber bonusLotteryNumber;

    public WinningLottery(List<LotteryNumber> lotteryNumbers, LotteryNumber bonusLotteryNumber) {
        this.winningLottery = new Lottery(lotteryNumbers);
        validate(bonusLotteryNumber);
        this.bonusLotteryNumber = bonusLotteryNumber;
    }

    private void validate(LotteryNumber bonusLotteryNumber) {
        if (winningLottery.contains(bonusLotteryNumber)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public LotteryResult createLotteryResult(List<Lottery> lotteries) {
        return new LotteryResult(winningCounts(lotteries), LotteryCompany.LOTTERY_PRICE);
    }

    private EnumMap<LotteryRank, Integer> winningCounts(List<Lottery> lotteries) {
        return new EnumMap<>(lotteries.stream()
                .map(this::getLotteryRank)
                .collect(Collectors.toMap(Function.identity(), value -> 1, (existing, replacement) -> existing + 1)));
    }

    private LotteryRank getLotteryRank(Lottery lottery) {
        return LotteryRank.valueOf(winningLottery.contains(lottery), winningLottery.contains(bonusLotteryNumber));
    }

}
