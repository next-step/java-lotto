package src;

import src.domain.Money;

public class InputMoney {

    private final Money autoMoney;

    private final Money manualMoney;

    public InputMoney(Money autoMoney, Money manualMoney) {
        this.autoMoney = autoMoney;
        this.manualMoney = manualMoney;
    }

    public Money getManualMoney() {
        return manualMoney;
    }

    public Money getAutoMoney() {
        return autoMoney;
    }
}
