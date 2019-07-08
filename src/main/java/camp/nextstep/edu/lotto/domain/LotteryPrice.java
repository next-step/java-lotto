package camp.nextstep.edu.lotto.domain;

import camp.nextstep.edu.lotto.domain.vo.Money;

public final class LotteryPrice {
    private static final Money PRICE_OF_LOTTERY = Money.from(1_000);

    public static int calculateAvailableLottery(int investment) {
        final Money investmentMoney = Money.from(investment);
        return investmentMoney.divideBy(PRICE_OF_LOTTERY).intValue();
    }

    public static int intValue() {
        return PRICE_OF_LOTTERY.intValue();
    }
}
