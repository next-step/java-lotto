package lotto.domain;

public class Winner {
    private final AmountEnum amountEnum;
    private final Long count;

    public Winner(AmountEnum amountEnum, Long count) {
        this.amountEnum = amountEnum;
        this.count = count;
    }

    public Integer getAmount() {
        return amountEnum.getAmount();
    }

    public Integer getCollectedCount() {
        return amountEnum.getCollectedCount();
    }

    public Long getCount() {
        return count;
    }

    public boolean isSecond() {
        return amountEnum == AmountEnum.SECOND;
    }
}
