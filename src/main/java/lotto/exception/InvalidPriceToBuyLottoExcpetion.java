package lotto.exception;

public class InvalidPriceToBuyLottoExcpetion extends RuntimeException {
    private static final String MESSAGE = "구입 금액은 최소 1000원 이상입니다(현재 구입금액: %s).";

    public InvalidPriceToBuyLottoExcpetion(int price) {
        super(String.format(MESSAGE, price));
    }
}
