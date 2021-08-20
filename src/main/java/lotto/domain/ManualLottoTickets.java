package lotto.domain;

import java.util.List;

public class ManualLottoTickets {

    final List<LottoTicket> manualLottoTickets;

    public ManualLottoTickets(List<LottoTicket> manualLottoTickets) {
        this.manualLottoTickets = manualLottoTickets;
    }

    public List<LottoTicket> value() {
        return manualLottoTickets;
    }

    public int getCount() {
        return manualLottoTickets.size();
    }
}
