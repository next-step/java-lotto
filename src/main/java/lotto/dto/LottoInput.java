package lotto.dto;

import lotto.vo.Money;

import java.util.List;

public class LottoInput {
    private final Money money;
    private final int manualCount;
    private final List<String> manualLottoList;

    public LottoInput(Money money, int manualCount, List<String> manualLottoList) {
        this.money = money;
        this.manualCount = manualCount;
        this.manualLottoList = manualLottoList;
    }

    public Money getMoney() {
        return money;
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount(Money price) {
        return money.subtract(price.multiply(Money.create(manualCount))).divide(price).intValue();
    }

    public List<String> getManualLottoList() {
        return manualLottoList;
    }
}
