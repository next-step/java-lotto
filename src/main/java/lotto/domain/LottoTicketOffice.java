package lotto.domain;

import java.util.List;

public class LottoTicketOffice {

    private LottoTicketOffice() {
    }

    /**
     * @param lottoPurchase 구입 전략
     * @param amount        구입할 금액
     * @return {@code lottoPurchase} 전략으로 {@code amount}만큼 구매한 티켓의 리스트
     */
    public static List<LottoTicket> issue(final LottoPurchase lottoPurchase, final PurchaseAmount amount) {
        return lottoPurchase.purchase(amount);
    }
}
