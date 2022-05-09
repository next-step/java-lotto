package lotto.domain;

public class NumberOfUserGenerateLotto {
    private static final int MIN_VALUE = 0;

    private final int numberOfUserGenerateLotto;

    public NumberOfUserGenerateLotto(int numberOfUserGenerateLotto, UserAmount userAmount) {
        checkNegative(numberOfUserGenerateLotto);
        checkCanBuy(numberOfUserGenerateLotto, userAmount);
        this.numberOfUserGenerateLotto = numberOfUserGenerateLotto;
    }

    private void checkCanBuy(int numberOfUserGenerateLotto, UserAmount userAmount) {
        if (!userAmount.canBuy(numberOfUserGenerateLotto)) {
            throw new IllegalArgumentException(Message.EXCEED_CAN_BUY_COUNT.toString());
        }
    }

    public int getNumberOfUserGenerateLotto() {
        return this.numberOfUserGenerateLotto;
    }

    private void checkNegative(int numberOfUserGenerateLotto) {
        if (numberOfUserGenerateLotto < MIN_VALUE) {
            throw new IllegalArgumentException(Message.CANNOT_NEGATIVE.toString());
        }
    }

    private enum Message {
        CANNOT_NEGATIVE("음수일 수 없습니다."),
        EXCEED_CAN_BUY_COUNT("구매할 수 있는 개수를 초과하였습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return this.message;
        }
    }
}
