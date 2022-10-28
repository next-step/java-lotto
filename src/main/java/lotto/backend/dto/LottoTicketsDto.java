package lotto.backend.dto;

import lotto.backend.domain.LottoTicket;
import lotto.backend.domain.LottoTickets;

import java.util.Collections;
import java.util.List;

public class LottoTicketsDto {

    private final List<LottoTicket> values;

    public LottoTicketsDto(List<LottoTicket> lottoTickets) {
        this.values = lottoTickets;
    }

    public static LottoTicketsDto of(LottoTickets lottoTickets) {
        return new LottoTicketsDto(lottoTickets.getValues());
    }

    public int countOfTicket() {
        return values.size();
    }

    public List<LottoTicket> getValues() {
        return Collections.unmodifiableList(values);
    }
}
