package lotto.domain;

import java.util.List;

public class AutoLottoTickets {

    final List<LottoTicket> autoLottoTickets;

    public AutoLottoTickets(List<LottoTicket> autoLottoTickets) {
        this.autoLottoTickets = autoLottoTickets;
    }

    public List<LottoTicket> value() {
        return autoLottoTickets;
    }

    public int getCount() {
        return autoLottoTickets.size();
    }
}
