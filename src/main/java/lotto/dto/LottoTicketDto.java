package lotto.dto;

import lotto.lotto.LottoTicket;

import java.util.List;

public class LottoTicketDto {
    private final List<Integer> lottoNumbers;

    private LottoTicketDto(final LottoTicket lottoTicket) {
        this.lottoNumbers = lottoTicket.getNumbers();
    }

    public static LottoTicketDto of(final LottoTicket lottoTicket) {
        return new LottoTicketDto(lottoTicket);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }
}
