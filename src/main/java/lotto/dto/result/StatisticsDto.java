package lotto.dto.result;

import lotto.domain.Money;
import lotto.domain.Result;

public class StatisticsDto {
    private final Result result;
    private final Money purchaseMoney;

    public StatisticsDto(Result result, Money purchaseMoney) {
        this.result = result;
        this.purchaseMoney = purchaseMoney;
    }

    public Result getResult() {
        return result;
    }

    public Money getPurchaseMoney() {
        return purchaseMoney;
    }
}
