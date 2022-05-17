package lotto.domain;

import lotto.exceptions.InvalidManualLottoCountException;
import lotto.exceptions.PurchaseLottoTicketException;

public class Pay {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private final int pay;
    private final int manualLottoCount;

    public Pay(int pay) {
        this(pay, 0);
    }

    public Pay(int pay, int manualLottoCount) {
        validatePays(pay, manualLottoCount);
        this.pay = pay;
        this.manualLottoCount = manualLottoCount;
    }

    private static void validatePays(int pay, int manualLottoCount) {
        if (pay < LOTTO_TICKET_PRICE) {
            throw new PurchaseLottoTicketException("1000원 이하로는 로또를 구매할 수 없습니다.");
        }

        if (pay % LOTTO_TICKET_PRICE != 0) {
            throw new PurchaseLottoTicketException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }

        if (pay / LOTTO_TICKET_PRICE < manualLottoCount) {
            throw new InvalidManualLottoCountException("금액이 부족합니다.");
        }
    }

    public int getTicketCount() {
        return pay / LOTTO_TICKET_PRICE;
    }

    public int getPay() {
        return pay;
    }

    public int getAutoTicketCount() {
        return getTicketCount() - manualLottoCount;
    }
}
