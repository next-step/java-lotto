package lotto.domain.dto;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {

    private final List<Integer> numbers;

    private LottoTicketDto(final LottoTicket lottoTicket) {
        this.numbers = lottoTicket.getLottoNumbersAsInt();
    }

    private static LottoTicketDto of(final LottoTicket lottoTicket) {
        return new LottoTicketDto(lottoTicket);
    }

    public static List<LottoTicketDto> from(final LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets()
                .stream()
                .map(LottoTicketDto::of)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
