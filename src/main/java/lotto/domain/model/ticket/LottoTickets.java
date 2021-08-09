package lotto.domain.model.ticket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.model.result.LottoRank;
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
                .map(LottoRank::of)
                .forEach(lottoResult::add);
        return lottoResult;
    }

    public static LottoTickets merge(LottoTickets thisTickets, LottoTickets otherTickets) {
        return Stream.concat(
                        thisTickets.lottoTickets.stream(),
                        otherTickets.lottoTickets.stream())
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTickets::of));
    }
}
