package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        ArrayList<LottoTicket> list = new ArrayList<>();
        list.addAll(lottoTickets);

        this.tickets = list;
    }

    public int size() {
        return tickets.size();
    }

    public LottoResult checkWin(LottoWinner winner) {
        List<LottoWin> wins = tickets.stream()
                .map(ticket -> ticket.checkWin(winner))
                .collect(Collectors.toList());

        return LottoResult.of(wins);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}