package lottery.domain;

import lottery.domain.createstrategy.CreatingLotteryStrategy;

import java.util.List;

public class LotteryMachine {

    private static final String NOT_ENOUGH_MONEY = "요구하는 수량에 비해 돈이 부족합니다 -> ";
    private static final String QUANTITY_INFO = " / quantity: ";

    private final Money money;

    public LotteryMachine(final Money money) {
        this.money = money;
    }

    public List<Lottery> createLotteries(final CreatingLotteryStrategy creatingLotteryStrategy) {
        return creatingLotteryStrategy.createLotteries(money);
    }

    public int validateQuantityAndGet(final LotteryQuantity quantity) {
        requireOverBuyableQuantity(quantity);
        return (int) quantity.intStream()
                .count();
    }

    private void requireOverBuyableQuantity(final LotteryQuantity quantity) {
        if (money.getBuyableLotteryQuantity().isLessThan(quantity)) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY + money + QUANTITY_INFO + quantity);
        }
    }

}
