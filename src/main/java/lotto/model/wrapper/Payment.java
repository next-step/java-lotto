package lotto.model.wrapper;

public class Payment {

    public static final int LOTTO_PRICE = 1000;

    private final int money;

    private Payment(final int money) {
        this.money = money;
    }

    public static Payment of(final int money) {
        if (money < 0) {
            throw new IllegalArgumentException("payment must be greater than zero.");
        }

        return new Payment(money);
    }

    public int countLottoTicket() {
        return money / LOTTO_PRICE;
    }
}
