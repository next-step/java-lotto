package lotto.dto;

import java.util.List;
import lotto.domain.model.ticket.LottoTicket;

public class LottoTicketDto {

    private final List<Integer> lottoNumbers;

    private LottoTicketDto(final LottoTicket lottoTicket) {
        this.lottoNumbers = lottoTicket.toInts();
    }

    public static LottoTicketDto of(final LottoTicket lottoTicket) {
        return new LottoTicketDto(lottoTicket);
    }

    public List<Integer> values() {
        return lottoNumbers;
    }
}
