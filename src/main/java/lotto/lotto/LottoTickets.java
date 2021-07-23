package lotto.lotto;

import lotto.dto.LottoTicketDto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        validate(lottoTickets);

        this.lottoTickets = lottoTickets;
    }

    private void validate(List<LottoTicket> lottoTickets) {
        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("To init LottoTickets lottoTickets can't be null");
        }
    }

    public static LottoTickets from(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<LottoTicketDto> getLottoTicketDtos() {
        return lottoTickets.stream()
                .map(LottoTicketDto::of)
                .collect(Collectors.toList());
    }
}
