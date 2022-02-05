package lotto.controller;

import lotto.domain.Money;
import lotto.domain.ResultGroup;
import lotto.domain.WinningResult;

public class ResultGroupDto {

    private ResultGroup resultGroup;
    private Money money;

    public ResultGroupDto(ResultGroup resultGroup, Money money) {
        this.resultGroup = resultGroup;
        this.money = money;
    }

    public double getProfits() {
        double profit = 0;
        for (WinningResult result : WinningResult.winningResults()) {
            profit += resultGroup.howManyHave(result) * result.prize();
        }
        return profit / money.value();
    }

    public int howManyHave(WinningResult result) {
        return resultGroup.howManyHave(result);
    }
}
