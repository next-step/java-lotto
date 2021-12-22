package lotto.domain.strategy;

import lotto.domain.LottoTicket;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ManualLottoTicketsGenerator implements LottoTicketsGenerator {

    private final List<String> lottoTickets;
    private final int ticketsPrice;

    public ManualLottoTicketsGenerator(List<String> lottoTickets, int ticketPrice) {
        this.lottoTickets = lottoTickets;
        ticketsPrice = lottoTickets.size() * ticketPrice;
    }


    @Override
    public List<LottoTicket> generate() {
        return lottoTickets.stream()
                .map(LottoTicket::from)
                .collect(toList());
    }

    @Override
    public int ticketsPrice() {
        return ticketsPrice;
    }


}
