package lotto.common;

import lotto.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsParser {
    public LottoTickets parse(List<String> lottoTickets) {
        LottoTicketParser parser = new LottoTicketParser();
        return new LottoTickets(lottoTickets.stream()
                .map(parser::parse)
                .collect(Collectors.toList()));
    }
}
