package lotto.step2.dto;

import lotto.step2.domain.LottoTicketTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketDTOTest {
    public static final LottoTicketDTO LOTTO_TICKET_DTO = new LottoTicketDTO(LottoTicketTest.LOTTO_TICKET.lottoTicketInformation().getLottoTicket());
    
    @Test
    @DisplayName("LottoTicketDTO 생성")
    void create() {
        assertThat(LOTTO_TICKET_DTO).isNotNull();
    }
}