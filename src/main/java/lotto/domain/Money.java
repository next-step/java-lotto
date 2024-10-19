package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    public int calculateLottoAmount(int userMoney) {
        if (userMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        return userMoney / LOTTO_PRICE;
    }
}
