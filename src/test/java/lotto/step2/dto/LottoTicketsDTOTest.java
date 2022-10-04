package lotto.step2.dto;

import lotto.step2.domain.LottoTicketsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsDTOTest {
    public static final LottoTicketsDTO LOTTO_TICKETS_DTO = new LottoTicketsDTO(LottoTicketsTest.LOTTO_TICKETS.lottoTicketsInformation().getLottoTickets());
    
    @Test
    @DisplayName("LottoTicketsDTO 생성")
    void create() {
        assertThat(LOTTO_TICKETS_DTO).isNotNull();
    }
}