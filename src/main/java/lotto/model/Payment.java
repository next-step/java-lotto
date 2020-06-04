package lotto.model;

public class Payment {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private int money;

    private Payment(int money) {
        this.money = money;
    }

    public static Payment of(int money) {
        validateMoney(money);

        return new Payment(money);
    }

    private static void validateMoney(int money) {
        if (money <= ZERO) {
            throw new IllegalArgumentException("금액은 0 이상의 값으로 입력해주세요.");
        }
    }

    public int getCountLottoTicket() {
        return money / LOTTO_PRICE;
    }
}
