package lotto.domain;

import java.util.List;

public class LottoBuyer {
    private final LottoTickets manualLottoTickets;
    private final LottoTickets autoLottoTickets;

    public LottoBuyer(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets) {
        this(new LottoTickets(manualLottoTickets), new LottoTickets(autoLottoTickets));
    }

    public LottoBuyer(LottoTickets manualLottoTickets, LottoTickets autoLottoTickets) {
        this.manualLottoTickets = manualLottoTickets;
        this.autoLottoTickets = autoLottoTickets;
    }

    public int manualLottoTicketsCount() {
        return 0;
    }

    public int autoLottoTicketsCount() {
        return 0;
    }

    public LottoTickets allLottoTickets() {
        return null;
    }
}
