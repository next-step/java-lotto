package lottery.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryFactory {

    private static final List<LotteryNumber> lotteryNumbers = createAllLotteryNumbers();

    public static List<Lottery> getLotteries(final Money money) {
        return money.getBuyableLotteryQuantity()
                .intStream()
                .peek(i -> money.buyLottery())
                .mapToObj(i -> getLotteryNumbers())
                .map(Lottery::new)
                .collect(Collectors.toList());
    }

    public static List<Lottery> getLotteries(final List<String> stringLotteries) {
        return stringLotteries.stream()
                .map(Lottery::new)
                .collect(Collectors.toList());
    }

    public static LotteryQuantity getManualLotteryQuantity(final String quantity, final Money money) {
        LotteryQuantity lotteryQuantity = new LotteryQuantity(quantity);
        money.buyLotteries(lotteryQuantity);
        return lotteryQuantity;
    }

    private static List<LotteryNumber> createAllLotteryNumbers() {
        return IntStream.rangeClosed(LotteryNumber.MIN, LotteryNumber.MAX).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    private static List<LotteryNumber> getLotteryNumbers() {
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers.stream()
                .limit(Lottery.NUMBERS_SIZE)
                .collect(Collectors.toList());
    }

}
