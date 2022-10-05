package lotto.step2fixture.dto;

import lotto.step2.dto.LottoTicketDTO;
import lotto.step2fixture.domain.LottoTicketFixture;

public class LottoTicketDTOFixture {
    public static final LottoTicketDTO LOTTO_TICKET_DTO = new LottoTicketDTO(LottoTicketFixture.LOTTO_TICKET.lottoTicketInformation().getLottoTicket());
}
