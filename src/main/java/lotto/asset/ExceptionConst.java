package lotto.asset;

public class ExceptionConst {
    private ExceptionConst() {}

    public static final String NAN_MSG = "숫자가 아닙니다.";
    public static final String NPE_MSG = "null 객체가 발생했습니다.";

    public static final String LOTTO_RANGE_MSG = "로또 번호는 1부터 45까지 입니다.";
    public static final String BAD_MONEY_MSG = "money 는 0보다 큰 양수여야 합니다.";
    public static final String BAD_PRICE_MSG = "price 는 0보다 큰 양수여야 합니다.";
}
