package lotto.service.domain;

import lotto.service.model.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketRandomGeneratorTest {
    private final LottoTicketGenerator lottoTicketGenerator = new LottoTicketRandomGenerator();

    @Test
    @DisplayName("LottoTicket 정상 생성여부 검증")
    void makeLottoTicket() {
        LottoTicket lottoTicket = lottoTicketGenerator.makeLottoTicket();
        assertThat(lottoTicket).isNotNull();
    }

}
