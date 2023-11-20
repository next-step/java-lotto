package step2.lotto.domain;

public class LottoPurchaseInfo {

    private final int lottoTicketCount;

    private static final int LOTTO_PRICE = 1000;

    public LottoPurchaseInfo(final int inputMoney) {
        this.lottoTicketCount = inputMoney / LOTTO_PRICE;
    }

    public int getLottoPrice() {
        return lottoTicketCount;
    }
}
