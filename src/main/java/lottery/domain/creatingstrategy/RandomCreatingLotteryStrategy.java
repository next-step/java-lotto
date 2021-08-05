package lottery.domain.creatingstrategy;

import lottery.domain.lottery.Lotteries;
import lottery.domain.lottery.Lottery;
import lottery.domain.lottery.LotteryNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottery.domain.lottery.Lottery.LOTTERY_NUMBERS_SIZE;
import static lottery.domain.lottery.Lottery.PRICE;
import static lottery.domain.lottery.LotteryNumber.MAX;
import static lottery.domain.lottery.LotteryNumber.MIN;

public class RandomCreatingLotteryStrategy implements CreatingLotteryStrategy {

    private static final List<LotteryNumber> lotteryNumbers = createLotteryNumbers();

    private static List<LotteryNumber> createLotteryNumbers() {
        return IntStream.rangeClosed(MIN, MAX).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public Lotteries getLotteries(final int money) {
        return new Lotteries(getLotteriesByMoney(money));
    }

    private List<Lottery> getLotteriesByMoney(final int money) {
        return IntStream.range(0, money / PRICE)
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
