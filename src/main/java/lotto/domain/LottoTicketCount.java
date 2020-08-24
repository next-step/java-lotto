package lotto.domain;

public class LottoTicketCount {
    private static final int LOTTO_PRICE = 1000;
    private int lottoTicketCount;

    private LottoTicketCount(int money) {
        this.lottoTicketCount = calculateLottoTicketCount(money);
    }

    public static LottoTicketCount valueOf(int money) {
        return new LottoTicketCount(money);
    }

    private int calculateLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }
}
