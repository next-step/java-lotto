package lottery.domain;

import lottery.view.ManualLotteryConsoleInput;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LotteryOrder {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";
    private static final String NOT_ENOUGH_MONEY = "로또를 구매하기에 돈이 부족합니다 -> ";
    private static final String NOT_ENOUGH_QUANTITY = "요구한 수량이 너무 많습니다 -> 가능한 수량: ";
    private static final String QUANTITY_INFO = " / 요구한 수량: ";

    private final LotteryQuantity randomQuantity;
    private final List<String> manualStringLotteries;

    public LotteryOrder(final Money money, final LotteryQuantity manualQuantity) {
        requireOverLotteryPrice(money);
        LotteryQuantity randomQuantity = new LotteryQuantity(money.divideFloor(Lottery.PRICE));
        requireOverPossibleQuantity(manualQuantity, randomQuantity);
        this.randomQuantity = randomQuantity.extract(manualQuantity);
        this.manualStringLotteries = ManualLotteryConsoleInput.askLotteries(manualQuantity.getQuantity());
    }

    public LotteryOrder(final Money money, final List<String> manualStringLotteries) {
        requireOverLotteryPrice(money);
        LotteryQuantity randomQuantity = new LotteryQuantity(money.divideFloor(Lottery.PRICE));
        LotteryQuantity manualQuantity = new LotteryQuantity(manualStringLotteries.size());
        requireOverPossibleQuantity(manualQuantity, randomQuantity);
        this.randomQuantity = randomQuantity.extract(manualQuantity);
        this.manualStringLotteries = manualStringLotteries;
    }

    public LotteryQuantity getRandomQuantity() {
        return randomQuantity;
    }

    public List<String> getManualStringLotteries() {
        return Collections.unmodifiableList(manualStringLotteries);
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
