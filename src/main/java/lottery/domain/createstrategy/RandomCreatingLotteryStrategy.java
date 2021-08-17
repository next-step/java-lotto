package lottery.domain.createstrategy;

import lottery.domain.Lottery;
import lottery.domain.LotteryNumber;
import lottery.domain.Money;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomCreatingLotteryStrategy implements CreatingLotteryStrategy {

    private static final List<LotteryNumber> lotteryNumbers = createAllLotteryNumbers();

    @Override
    public List<Lottery> createLotteries(final Money money) {
        return money.getBuyableLotteryQuantity()
                .intStream()
                .peek(i -> money.extractLotteryPrice())
                .mapToObj(i -> getRandomLottery())
                .collect(Collectors.toList());
    }

    private static List<LotteryNumber> createAllLotteryNumbers() {
        return IntStream.rangeClosed(LotteryNumber.MIN, LotteryNumber.MAX).boxed()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    private Lottery getRandomLottery() {
        Collections.shuffle(lotteryNumbers);
        return new Lottery(lotteryNumbers.stream()
                .limit(Lottery.NUMBERS_SIZE)
                .collect(Collectors.toList()));
    }

}
