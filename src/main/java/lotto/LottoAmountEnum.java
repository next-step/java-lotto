package lotto;

public enum LottoAmountEnum {
    UNIT_AMOUNT(1000),
    THREE_MATCHING_AMOUNT(5000),
    FOUR_MATCHING_AMOUNT(50000),
    FIVE_MATCHING_AMOUNT(1500000),
    SIX_MATCHING_AMOUNT(2000000000);
    private int value ;

    LottoAmountEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
