package step2.model;

public class Payment {

    private static final int LOTTO_PRICE = 1000;

    private int money;

    private Payment(int money) {
        this.money = money;
    }

    public static Payment of(int money) {
        return new Payment(money);
    }

    public int getCountLottoTicket() {
        return money / LOTTO_PRICE;
    }
}
