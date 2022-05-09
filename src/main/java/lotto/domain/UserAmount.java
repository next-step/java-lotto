package lotto.domain;

import java.util.List;

public class UserAmount {
    private static final int MIN_USER_AMOUNT = 0;
    private static final int LOTTO_PRICE = 1000;

    private final int userAmount;

    public UserAmount(List<LottoNumbers> lottos) {
        this(lottos.size() * LOTTO_PRICE);
    }

    public UserAmount(int userAmount) {
        checkNegative(userAmount);
        checkLessThenLottoPrice(userAmount);
        this.userAmount = userAmount;
    }

    private void checkLessThenLottoPrice(int userAmount) {
        if (userAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(Message.USER_AMOUNT_LESS_THEN_LOTTO_PRICE.toString());
        }
    }

    private void checkNegative(int userAmount) {
        if (userAmount < MIN_USER_AMOUNT) {
            throw new IllegalArgumentException(Message.NOT_ALLOW_NEGATIVE.toString());
        }
    }

    public double calculateRevenue(int sum) {
        return sum / this.userAmount;
    }

    public int getRandomLottoSize(List<LottoNumbers> userInputLottos) {
        return getRandomLottoSize(userInputLottos.size());
    }

    int getRandomLottoSize(int userInputLottosSize) {
        return (this.userAmount / LOTTO_PRICE) - userInputLottosSize;
    }

    private enum Message {
        NOT_ALLOW_NEGATIVE("금액은 음수일 수 없습니다."),
        USER_AMOUNT_LESS_THEN_LOTTO_PRICE("로또 가격보다 적을 수 없습니다.");

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
