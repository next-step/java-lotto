package lotto.model;

import java.util.Objects;

public class CountInfo {
    private static final int ZERO = 0;
    private static final Money BASE_MONEY_UNIT = new Money(1000);

    private final int randomCount;
    private final int manualCount;

    public CountInfo(Money buyingMoney, int manualCount) {
        validate(buyingMoney, manualCount);
        this.randomCount = buyingMoney.calculateUnitCount(BASE_MONEY_UNIT) - manualCount;
        this.manualCount = manualCount;
    }

    private void validate(Money money, int manualCount) {
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

    private boolean isNegative(int manualCount) {
        if (manualCount < ZERO) return true;
        return false;
    }

    public int getRandomCount() {
        return randomCount;
    }

    public int getManualCount() {
        return manualCount;
    }
}
