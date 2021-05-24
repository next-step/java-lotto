package lotto.domain;

import lotto.common.WinningType;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> LOTTO_TICKETS;

    public LottoTickets(int lottoTicketCount) {
        this.LOTTO_TICKETS = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            this.LOTTO_TICKETS.add(new LottoTicket());
        }
    }

    public String printLottoTickets() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoTicket lottoTicket : LOTTO_TICKETS) {
            stringBuilder.append(lottoTicket.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public List<WinningType> getWinningTypes(LottoTicket winningLottoTicket) {

        List<WinningType> winningTypes = new ArrayList<>();
        for (LottoTicket lottoTicket : this.LOTTO_TICKETS) {
            winningTypes.add(lottoTicket.findWinningType(winningLottoTicket));
        }

        return winningTypes;
    }
}
