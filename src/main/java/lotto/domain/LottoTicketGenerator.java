package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    private LottoTicketGenerator() {
        throw new UnsupportedOperationException("인스턴스를 생성할 수 없습니다.");
    }

    public static LottoTicket createTicket(final LottoPurchasePrice purchasePrice, final LottoTicket manualLottoTicket) {
        List<Lotto> manualTicket = manualLottoTicket.getTicket();

        int autoIssueCount = purchasePrice.getAutoLottoCount(manualLottoTicket.getTicketSize());
        List<Lotto> autoTicket = new LottoTicket(autoIssueCount).getTicket();

        List<Lotto> allTicket = new ArrayList<>(autoTicket);
        allTicket.addAll(manualTicket);

        return new LottoTicket(allTicket);
    }

}
