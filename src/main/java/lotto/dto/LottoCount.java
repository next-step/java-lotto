package lotto.dto;

import lotto.model.Money;

import java.util.Objects;

public class LottoCount {
    private static final int ZERO = 0;
    private static final Money BASE_MONEY_UNIT = new Money(1000);

    private final long randomCount;
    private final long manualCount;

    public LottoCount(Money buyingMoney, long manualCount) {
        validate(buyingMoney, manualCount);
        this.randomCount = buyingMoney.calculateUnitCount(BASE_MONEY_UNIT) - manualCount;
        this.manualCount = manualCount;
    }

    private void validate(Money money, long manualCount) {
        Objects.requireNonNull(money, "구매 금액은 null일 수 없습니다.");

        if (!money.isDivided(BASE_MONEY_UNIT)) {
            throw new IllegalArgumentException("로또 구매시 지불하는 금액 단위가 올바르지 않습니다. money: " + money);
        }
        if (isNegative(manualCount)) {
            throw new IllegalArgumentException("수동 로또 구매 개수는 음수일 수 없습니다. manualCount : " + manualCount);
        }
        if (money.calculateUnitCount(BASE_MONEY_UNIT) < manualCount) {
            throw new IllegalArgumentException("수동 로또 구매시 필요한 금액이 총 구매 금액을 넘을 수 없습니다. money:" + money + ", count:" + manualCount);
        }
    }

    private boolean isNegative(long manualCount) {
        return manualCount < ZERO;
    }

    public long getRandomCount() {
        return randomCount;
    }

    public long getManualCount() {
        return manualCount;
    }
}
