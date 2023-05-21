package lotto.model;

public enum LotteryEnum {
    LOTTERY_MIN(1),
    LOTTERY_MAX(45),
    NUMBER_PER_TICKET(6),
    LOTTERY_PRICE(1000);

    private final int value;

    LotteryEnum(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
