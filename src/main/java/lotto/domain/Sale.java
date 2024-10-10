package lotto.domain;

public class Sale {
    private static final String LOTTO_ERROR_MESSAGE="돈이 부족합니다.";
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Sale(int money) {
        this.money = parse(money);
    }

    public int purchase(int money) {
        return money / LOTTO_PRICE;
    }

    private int parse(int money) {
        if(isValidate(money)) {
            throw new IllegalArgumentException(LOTTO_ERROR_MESSAGE);
        }
        return money;
    }

    private boolean isValidate(int money) {
        return money < 1000;
    }

}
