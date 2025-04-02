package lotto.domain;

import lotto.domain.model.game.LottoGame;
import lotto.domain.model.game.LottoGameResult;
import lotto.domain.model.lotto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoService {

    private final LottoTicketFactory ticketFactory = new LottoTicketFactory();

    public List<LottoTicket> purchaseTickets(final List<LottoTicket> manualTickets, final TotalTicketCount totalTicketCount) {
        List<LottoTicket> allTickets = new ArrayList<>(manualTickets);
        List<LottoTicket> autoTickets = purchaseAutoTickets(totalTicketCount.getAutoTicketCount());
        allTickets.addAll(autoTickets);
        return allTickets;
    }

    private List<LottoTicket> purchaseAutoTickets(final TicketCount ticketCount) {
        return ticketFactory.create(ticketCount.getCount());
    }

    public LottoGameResult draw(final List<LottoTicket> lottoTickets, final WinningLottoTicket winningLottoTicket) {
        return new LottoGame(lottoTickets, winningLottoTicket).draw();
    }
}
