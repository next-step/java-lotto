package lotto.domain;

public class Budget {

    private final static String NOT_A_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String LACK_OF_MONEY_EXCEPTION_MESSAGE = "로또 한장의 구입 가격보다 투입 금액이 적습니다.";

    private final int value;

    public Budget(final String budget) {
        try {
            this.value = Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format("%s (Input: %s)", NOT_A_NUMBER_EXCEPTION_MESSAGE, budget));
        }
    }

    public int getNumberOfPurchase(final int priceOfLotto) {
        validatePossibleToPurchase(priceOfLotto);
        return this.value / priceOfLotto;
    }

    private void validatePossibleToPurchase(final int priceOfLotto) {
        if (canNotPurchase(priceOfLotto)) {
            throw new IllegalArgumentException(LACK_OF_MONEY_EXCEPTION_MESSAGE);
        }
    }

    public boolean canNotPurchase(final int priceOfLotto) {
        return this.value < priceOfLotto;
    }
}
