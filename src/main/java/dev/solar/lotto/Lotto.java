package dev.solar.lotto;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    public int buyLotto(final int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public LottoTicket pick() {
        return LottoTicket.buyOne();
    }
}
