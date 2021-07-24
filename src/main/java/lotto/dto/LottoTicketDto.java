package lotto.dto;

import lotto.lotto.LottoTicket;

import java.util.Collections;
import java.util.List;

public class LottoTicketDto {
    private final List<Integer> lottoNumbers;

    private LottoTicketDto(final LottoTicket lottoTicket) {
        this.lottoNumbers = lottoTicket.getNumbers();

        Collections.sort(lottoNumbers);
    }

    public static LottoTicketDto from(final LottoTicket lottoTicket) {
        return new LottoTicketDto(lottoTicket);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
