package lotto.view;

import lotto.domain.item.LottoTicket;

import java.util.List;

public class LottoDto {
    private List<LottoTicket> tickets;

    public void setTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }
}
