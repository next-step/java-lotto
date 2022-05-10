package lotto.domain;

public class NumberOfUserGenerateLotto {
    private static final String CANNOT_NEGATIVE_MESSAGE = "음수일 수 없습니다.";
    private static final String EXCEED_CAN_BUY_COUNT_MESSAGE = "구매할 수 있는 개수를 초과하였습니다.";
    private static final int MIN_VALUE = 0;

    private final int numberOfUserGenerateLotto;

    public NumberOfUserGenerateLotto(int numberOfUserGenerateLotto, UserAmount userAmount) {
        checkNegative(numberOfUserGenerateLotto);
        checkCanBuy(numberOfUserGenerateLotto, userAmount);
        this.numberOfUserGenerateLotto = numberOfUserGenerateLotto;
    }

    private void checkCanBuy(int numberOfUserGenerateLotto, UserAmount userAmount) {
        if (!userAmount.canBuy(numberOfUserGenerateLotto)) {
            throw new IllegalArgumentException(EXCEED_CAN_BUY_COUNT_MESSAGE);
        }
    }

    public int getNumberOfUserGenerateLotto() {
        return this.numberOfUserGenerateLotto;
    }

    private void checkNegative(int numberOfUserGenerateLotto) {
        if (numberOfUserGenerateLotto < MIN_VALUE) {
            throw new IllegalArgumentException(CANNOT_NEGATIVE_MESSAGE);
        }
    }
}
