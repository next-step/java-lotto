package lotto.step2.dto;

import lotto.step2fixture.dto.LottoTicketDTOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketDTOTest {
    @Test
    @DisplayName("LottoTicketDTO 생성")
    void create() {
        assertThat(LottoTicketDTOFixture.LOTTO_TICKET_DTO).isNotNull();
    }
}