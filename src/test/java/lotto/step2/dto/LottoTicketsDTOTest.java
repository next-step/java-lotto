package lotto.step2.dto;

import lotto.step2fixture.dto.LottoTicketsDTOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsDTOTest {
    @Test
    @DisplayName("LottoTicketsDTO 생성")
    void create() {
        assertThat(LottoTicketsDTOFixture.LOTTO_TICKETS_DTO).isNotNull();
    }
}