package lotto.domain;

import java.util.List;

public class LottoGame {

    private final PurchaseInfo purchaseInfo;
    private final LottoTickets lottoTickets = LottoTickets.newInstance();

    public LottoGame(PurchaseInfo purchaseInfo) {
        validatePurchaseInfo(purchaseInfo);

        this.purchaseInfo = purchaseInfo;
        this.lottoTickets.addAll(purchaseInfo.getManualTickets());
    }

    private void validatePurchaseInfo(PurchaseInfo purchaseInfo) {
        if (purchaseInfo == null) {
            throw new IllegalArgumentException("구매 정보가 존재하지 않습니다.");
        }
    }

    public LottoTickets createAutoLottoTickets() {
        int autoTicketCount = this.purchaseInfo.getAutoTicketCount();
        List<LottoTicket> autoLottoTickets = LottoTicketFactory.createAutoLottoTickets(autoTicketCount);
        return this.lottoTickets.addAll(autoLottoTickets);
    }

    public LottoMatchResult calculateMatchCount(LottoTicket lastWinLottoTicket, LottoNumber bonusNumber) {
        return this.lottoTickets.calculateMatchCount(lastWinLottoTicket, bonusNumber);
    }
}
