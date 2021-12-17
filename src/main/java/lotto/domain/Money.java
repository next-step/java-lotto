package lotto.domain;

public class Money {

    private static final String INPUT_AMOUNT_ZERO_UP = "금액은 0원 이상 입력해주세요.";
    private static final String LOTTO_PRICE_MESSAGE = "1000원 단위로만 구입이 가능합니다.";
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(INPUT_AMOUNT_ZERO_UP);
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_MESSAGE);
        }
    }

    public int numberOfPurchase(){
       return money / LOTTO_PRICE;
    }
}
