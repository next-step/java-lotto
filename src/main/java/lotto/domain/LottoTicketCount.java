package lotto.domain;

public class LottoTicketCount {
    private static final int LOTTO_PRICE = 1000;
    private int lottoTicketCount;

    public LottoTicketCount(int money) {
        this.lottoTicketCount = calculateLottoTicketCount(money);
    }

    private int calculateLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }
}
