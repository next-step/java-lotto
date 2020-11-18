package lotto.dto;

import lotto.domain.Money;
import lotto.domain.Result;

public class StatisticsDto {
    private Result result;
    private Money purchaseMoney;

    public StatisticsDto(Result result, Money purchaseMoney) {
        this.result = result;
        this.purchaseMoney = purchaseMoney;
    }

    Result getResult() {
        return result;
    }

    Money getPurchaseMoney() {
        return purchaseMoney;
    }
}
