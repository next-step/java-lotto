package domain;

public class Money {
    private final int money;
    private final int LOTTO_PRICE = 1000;

    public Money(int money) {
        correctMoney(money);
        this.money = money;
    }

    public int lottoCount() {
        return money / LOTTO_PRICE;
    }

    private void correctMoney(int money) {
        if (money < 0 || money % LOTTO_PRICE != 0)
            throw new IllegalArgumentException("잘못된 구입금액 입니다");
    }
}
