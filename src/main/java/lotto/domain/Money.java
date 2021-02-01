package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private int money;
    private int lottoCnt;

    public int getLottoTicketCount(int money) {
        this.money = money;
        this.lottoCnt = this.money / LOTTO_PRICE;
        return lottoCnt;
    }

}
