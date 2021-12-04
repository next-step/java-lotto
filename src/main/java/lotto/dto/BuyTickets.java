package lotto.dto;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.ResultLotto;

public class BuyTickets {

    private final LottoTickets assignLottoTickets;
    private final LottoTickets randomLottoTickets;

    public BuyTickets(LottoTickets assignLottoTickets,
        LottoTickets randomLottoTickets) {
        this.assignLottoTickets = assignLottoTickets;
        this.randomLottoTickets = randomLottoTickets;
    }

    public int getAssignTicketSize() {
        return assignLottoTickets.getTicketSize();
    }

    public int getRandomTicketSize() {
        return randomLottoTickets.getTicketSize();
    }

    public List<LottoTicket> getAllTicketToList() {
        return getAllTicket().getTickets();
    }

    public LottoTickets getAllTicket() {
        return assignLottoTickets.addAll(randomLottoTickets);
    }

    public GameResult result(ResultLotto resultLotto) {
        return getAllTicket().result(resultLotto);
    }
}
