package study.step4.domain;

public class LottoMoney {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoMoney(String money) {
        this(Integer.parseInt(money));
    }

    public LottoMoney(int money) {
        valid(money);
        this.money = money;
    }

    private void valid(int money) {
        if ((money < 0) || (money % LOTTO_PRICE != 0)) {
            throw new IllegalArgumentException("로또 구매 최저 금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }

    public int totalCount() {
        return money / LOTTO_PRICE;
    }

    public int buyableCount(LottoTicketCount manualCount) {
        int ticketCount = totalCount() - manualCount.getLottoTicketCount();
        if (ticketCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 로또 수가 구입금액 보다 큽니다.");
        }
        return ticketCount;
    }

    public int getMoney() {
        return money;
    }
}
