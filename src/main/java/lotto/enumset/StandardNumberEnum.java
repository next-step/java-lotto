package lotto.enumset;

public enum StandardNumberEnum {

    LOTTO_BONUS_PRINT_NUMBER_INDEX(3),
    LOTTO_BONUS_INDEX_BELOW_CHARGE(2),
    LOTTO_BONUS_INDEX_MORETHEN_CHARGE(3);

    private int numValue;

    StandardNumberEnum(int numValue) {
        this.numValue = numValue;
    }

    public int value() {
        return this.numValue;
    }

}
