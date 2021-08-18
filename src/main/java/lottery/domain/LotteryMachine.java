package lottery.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotteryMachine {

    private static final List<LotteryNumber> lotteryNumbers = IntStream.rangeClosed(LotteryNumber.MIN, LotteryNumber.MAX).boxed()
            .map(LotteryNumber::new)
            .collect(Collectors.toList());
    private static final String NON_NULL = "입력값은 null 일 수 없습니다";
    private static final String NOT_ENOUGH_MONEY = "로또를 구매하기에 돈이 부족합니다 -> ";
    private static final String NOT_ENOUGH_QUANTITY = "요구한 수량이 너무 많습니다 -> 가능한 수량: ";
    private static final String QUANTITY_INFO = " / 요구한 수량: ";

    private final LotteryQuantity randomQuantity;

    public LotteryMachine(final Money money) {
        requireOverLotteryPrice(money);
        this.randomQuantity = new LotteryQuantity(money.divideFloor(Lottery.PRICE));
    }

    public LotteryMachine(final Money money, final LotteryQuantity manualQuantity) {
        requireOverLotteryPrice(money);
        LotteryQuantity randomQuantity = new LotteryQuantity(money.divideFloor(Lottery.PRICE));
        requireOverPossibleQuantity(manualQuantity, randomQuantity);
        this.randomQuantity = randomQuantity.extract(manualQuantity);
    }

    public Lotteries createLotteries() {
        return new Lotteries(getRandomLotteries());
    }

    public Lotteries createLotteries(final List<String> stringLotteries) {
        requireNonNull(stringLotteries);
        return new Lotteries(Stream.of(getManualLotteries(stringLotteries), getRandomLotteries())
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()));
    }

    private List<Lottery> getManualLotteries(final List<String> stringLotteries) {
        return stringLotteries.stream()
                .map(Lottery::new)
                .collect(Collectors.toList());
    }

    private List<Lottery> getRandomLotteries() {
        return randomQuantity.intStream()
                .mapToObj(i -> getRandomLottery())
                .collect(Collectors.toList());
    }

    private Lottery getRandomLottery() {
        Collections.shuffle(lotteryNumbers);
        return new Lottery(lotteryNumbers.stream()
                .limit(Lottery.NUMBERS_SIZE)
                .collect(Collectors.toList()));
    }

    private <T> void requireNonNull(final T t) {
        if (Objects.isNull(t)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    private void requireOverPossibleQuantity(final LotteryQuantity manualQuantity, final LotteryQuantity randomQuantity) {
        requireNonNull(manualQuantity);
        requireNonNull(randomQuantity);
        if (randomQuantity.isLessThan(manualQuantity)) {
            throw new IllegalArgumentException(NOT_ENOUGH_QUANTITY + randomQuantity + QUANTITY_INFO + manualQuantity);
        }
    }

    private void requireOverLotteryPrice(final Money money) {
        requireNonNull(money);
        if (money.compareTo(Lottery.PRICE) < 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY + money);
        }
    }

}
