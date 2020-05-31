package lotto.domain;

import java.util.Collections;
import java.util.List;

public class PurchaseInfo {

    private final int autoTicketCount;
    private final int manualTicketCount;
    private final List<LottoTicket> manualTickets;

    private PurchaseInfo(PurchasePrice purchasePrice, List<LottoTicket> manualTickets) {
        validatePurchasePrice(purchasePrice);
        validateManualTickets(manualTickets);

        this.manualTicketCount = manualTickets.size();
        this.autoTicketCount = purchasePrice.calculatePurchaseCount() - this.manualTicketCount;
        this.manualTickets = Collections.unmodifiableList(manualTickets);
    }

    public static PurchaseInfo newInstance(PurchasePrice purchasePrice, List<LottoTicket> manualTickets) {
        return new PurchaseInfo(purchasePrice, manualTickets);
    }

    private void validatePurchasePrice(PurchasePrice purchasePrice) {
        if (purchasePrice == null) {
            throw new IllegalArgumentException("구매 금액이 존재하지 않습니다.");
        }
    }

    private void validateManualTickets(List<LottoTicket> manualTickets) {
        if (manualTickets == null) {
            throw new IllegalArgumentException("수동 로또번호 정보가 존재하지 않습니다.");
        }
    }

    public int getAutoTicketCount() {
        return this.autoTicketCount;
    }

    public int getManualTicketCount() {
        return this.manualTicketCount;
    }

    public List<LottoTicket> getManualTickets() {
        return this.manualTickets;
    }
}
