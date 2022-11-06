package lotto.backend.dto;

import lotto.backend.domain.LottoTicket;
import lotto.backend.domain.LottoTickets;

import java.util.Collections;
import java.util.List;

public class LottoTicketsDto {

    private final LottoTickets values;

    public LottoTicketsDto(LottoTickets lottoTickets) {
        this.values = lottoTickets;
    }

    public int countOfTicket() {
        return values.size();
    }

    public int countOfAuto() {
        return values.countOfAutoLotto();
    }

    public int countOfCustom() {
        return values.countOfCustomLotto();
    }

    public List<LottoTicket> getValues() {
        return Collections.unmodifiableList(values.getValues());
    }


}
