package lotto.domain;

import lotto.exceptions.PurchaseLottoTicketException;

public class Pay {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private final int pay;

    public Pay(int pay) {
        validatePays(pay);
        this.pay = pay;
    }

    private static void validatePays(int pay) {
        if (pay < LOTTO_TICKET_PRICE) {
            throw new PurchaseLottoTicketException("1000원 이하로는 로또를 구매할 수 없습니다.");
        }

        if (pay % LOTTO_TICKET_PRICE != 0) {
            throw new PurchaseLottoTicketException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    public int getTicketCount() {
        return pay / LOTTO_TICKET_PRICE;
    }

}
