package lottery.domain.creatingstrategy;

import lottery.domain.Lotteries;
import lottery.domain.Lottery;
import lottery.domain.LotteryNumber;
import lottery.domain.Money;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottery.domain.Lottery.LOTTERY_NUMBERS_SIZE;
import static lottery.domain.LotteryNumber.MAX;
import static lottery.domain.LotteryNumber.MIN;

public class RandomCreatingLotteryStrategy implements CreatingLotteryStrategy {

    private static final List<LotteryNumber> lotteryNumbers = createLotteryNumbers();

    private static List<LotteryNumber> createLotteryNumbers() {
        return IntStream.rangeClosed(MIN, MAX).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public Lotteries getLotteries(final Money money) {
        return new Lotteries(getLotteriesByMoney(money));
    }

    private List<Lottery> getLotteriesByMoney(final Money money) {
        return IntStream.range(0, money.getBuyableLotteryCount())
                .mapToObj(i -> getLottery())
                .collect(Collectors.toList());
    }

    private Lottery getLottery() {
        return new Lottery(getLotteryNumbers());
    }

    private List<LotteryNumber> getLotteryNumbers() {
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers.stream()
                .limit(LOTTERY_NUMBERS_SIZE)
                .collect(Collectors.toList());
    }
}
