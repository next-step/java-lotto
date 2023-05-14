package lotto.model;

public class Cost {

    public static final int ONE_LOTTO_TICKET_PRICE = 1_000;
    private int money;

    public Cost(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getLottoTicketCount() {
        return this.money / ONE_LOTTO_TICKET_PRICE;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("구입 금액은 음수일 수 없습니다.");
        }
    }


}
