package lotto.domain;

public class LottoTicketCount {
    private static final int LOTTO_PRICE = 1000;
    private final int lottoTicketCount;

    private LottoTicketCount(LottoMoney lottoMoney) {
        this.lottoTicketCount = calculateLottoTicketCount(lottoMoney.getMoney());
    }

    public static LottoTicketCount getInstance(LottoMoney lottoMoney) {
        return new LottoTicketCount(lottoMoney);
    }

    private int calculateLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }
}
