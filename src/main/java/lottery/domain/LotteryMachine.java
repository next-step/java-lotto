package lottery.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotteryMachine {

    private static final List<LotteryNumber> lotteryNumbers = IntStream.rangeClosed(LotteryNumber.MIN, LotteryNumber.MAX).boxed()
            .map(LotteryNumber::new)
            .collect(Collectors.toList());

    public static Lotteries createLotteries(final LotteryOrder lotteryOrder) {
        List<Lottery> manualLotteries = lotteryOrder.getManualStringLotteries()
                .stream()
                .map(Lottery::new)
                .collect(Collectors.toList());
        List<Lottery> randomLotteries = lotteryOrder.getRandomQuantity()
                .intStream()
                .mapToObj(i -> getRandomLottery())
                .collect(Collectors.toList());
        return new Lotteries(Stream.of(manualLotteries, randomLotteries)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()));
    }

    private static Lottery getRandomLottery() {
        Collections.shuffle(lotteryNumbers);
        return new Lottery(lotteryNumbers.stream()
                .limit(Lottery.NUMBERS_SIZE)
                .collect(Collectors.toList()));
    }

}
