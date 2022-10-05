package lotto.step2fixture.dto;

import lotto.step2.dto.LottoTicketsDTO;
import lotto.step2fixture.domain.LottoTicketsFixture;

public class LottoTicketsDTOFixture {
    public static final LottoTicketsDTO LOTTO_TICKETS_DTO = new LottoTicketsDTO(LottoTicketsFixture.LOTTO_TICKETS.lottoTicketsInformation().getLottoTickets());
}
