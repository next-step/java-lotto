package step2.lotto.domain;

public class LottoPurchase {

    private final int lottoPurchaseMoney;
    private final int lottoTicketCount;

    private static final int LOTTO_PRICE = 1000;

    public LottoPurchase(final int inputMoney) {
        this.lottoPurchaseMoney = inputMoney;
        this.lottoTicketCount = inputMoney / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public int getLottoPurchaseMoney() {
        return lottoPurchaseMoney;
    }
}
