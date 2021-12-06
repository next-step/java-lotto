package step4.dto;

import step4.domain.Money;

import java.util.List;

public class LottoInformation {
    
    private final Money money;
    private final List<String> manualList;

    public LottoInformation(Money money, List<String> manualList) {
        this.money = money;
        this.manualList = manualList;
    }

    public Money getMoney() {
        return money;
    }

    public List<String> getManualList() {
        return manualList;
    }
}
