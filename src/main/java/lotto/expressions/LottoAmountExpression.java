package lotto.expressions;

public class LottoAmountExpression {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final String INVALID_PRICE_FOR_PURCHASE_MESSAGE =
            "로또를 구입하려면 1장에 1000원 입니다. 1000원 단위로 입력해주세요.";
    private static final String INVALID_PRICE_PER_PIECE_MESSAGE = "1000원 단위로 입력해주세요.";

    private LottoAmountExpression() {
    }

    public static int validateAmount(int amount) {
        if (amount < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(INVALID_PRICE_FOR_PURCHASE_MESSAGE);
        }
        if (amount % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_PER_PIECE_MESSAGE);
        }
        return amount;
    }

    public static int toInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (Exception e) {
            throw new NumberFormatException(NOT_NUMBER_MESSAGE);
        }
    }
}
