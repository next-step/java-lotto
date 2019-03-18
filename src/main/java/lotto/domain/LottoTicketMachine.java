package lotto.domain;

public class LottoTicketMachine {
    public static final int LOTTO_UNIT_PRICE = 1000;

    public static LottoTicket purchase(final int purchaseAmount) {
        if (purchaseAmount < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException();
        }

        return new LottoTicket((int) Math.floor(purchaseAmount / LOTTO_UNIT_PRICE));
    }
}
