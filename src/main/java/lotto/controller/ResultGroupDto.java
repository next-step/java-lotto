package lotto.controller;

import lotto.domain.Money;
import lotto.domain.ResultGroup;

public class ResultGroupDto {

    private final ResultGroup resultGroup;
    private final Money money;

    public ResultGroupDto(ResultGroup resultGroup, Money money) {
        this.resultGroup = resultGroup;
        this.money = money;
    }

    public ResultGroup getResultGroup() {
        return resultGroup;
    }

    public Money getMoney() {
        return money;
    }
}
