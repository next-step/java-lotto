package lottery.dto;

import lottery.domain.Money;

public class LotteryResultDto {

    private final String explanation;
    private final Money cashPrize;
    private final int count;

    public LotteryResultDto(final String explanation, final Money cashPrize, final int count) {
        this.explanation = explanation;
        this.cashPrize = cashPrize;
        this.count = count;
    }

    public String getExplanation() {
        return explanation;
    }

    public Money getCashPrize() {
        return cashPrize;
    }

    public int getCount() {
        return count;
    }
}
