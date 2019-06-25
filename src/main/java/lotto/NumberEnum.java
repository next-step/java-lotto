package lotto;

public enum NumberEnum {

    LOTTO_IS_WINNER_NUMBER_COUNT(1),
    LOTTO_ISNOT_WINNER_NUMBER_COUNT(0),
    LOTTO_DEFAULT_SIZE(6),
    LOTTO_ONE_GAME_PRICE(1000),
    DEFAULT_LOTTO_WINNER_TYPE(5),
    LOTTO_BONUS_PRINT_NUMBER_INDEX(3),
    LOTTO_BONUS_INDEX_BELOW_CHARGE(2),
    LOTTO_BONUS_INDEX_MORETHEN_CHARGE(3);

    private int numValue;

    NumberEnum(int numValue){
        this.numValue = numValue;
    }

    public int value(){
        return this.numValue;
    }

}
