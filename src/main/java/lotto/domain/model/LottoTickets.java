package lotto.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoResult;
import lotto.dto.LottoTicketDto;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicketDto> getTicketDtos() {
        return lottoTickets.stream()
                .map(LottoTicketDto::of)
                .collect(Collectors.toList());
    }

    public LottoResult match(WinningTicket winningTicket) {
        LottoResult lottoResult = LottoResult.empty();
        lottoTickets.stream()
                .map(winningTicket::match)
                .forEach(lottoResult::add);
        return lottoResult;
    }
}
