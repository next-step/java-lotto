package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryFactory {

    private static final List<LotteryNumber> lotteryNumbers = createAllLotteryNumbers();

    public static Lottery getLottery(final List<Integer> numbers) {
        return new Lottery(numbers.stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList()));
    }

    public static Lotteries getLotteries(final Money money) {
        return new Lotteries(getLotteriesByMoney(money));
    }

    private static List<LotteryNumber> createAllLotteryNumbers() {
        return IntStream.rangeClosed(LotteryNumber.MIN, LotteryNumber.MAX).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    private static List<Lottery> getLotteriesByMoney(final Money money) {
        return IntStream.range(0, money.getBuyableLotteryCount())
                .mapToObj(i -> getLotteryNumbers())
                .map(Lottery::new)
                .collect(Collectors.toList());
    }

    private static List<LotteryNumber> getLotteryNumbers() {
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers.stream()
                .limit(Lottery.NUMBERS_SIZE)
                .collect(Collectors.toList());
    }

}
