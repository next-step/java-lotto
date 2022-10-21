package lotto.dto;

import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {
    private final List<LottoDto> lottoTicket;

    public LottoTicketDto(LottoTicket lottoTicket) {
        this(lottoTicket.getLottos()
                .stream()
                .map(LottoDto::new)
                .collect(Collectors.toList()));
    }

    public LottoTicketDto(List<LottoDto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<LottoDto> lottoTicket() {
        return lottoTicket;
    }
}
