package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void LottoTicket_생성() {
        LottoTicket lottoTicket = new LottoTicket();

        int lottoNumberSize = 6;
        assertThat(lottoTicket.size()).isEqualTo(lottoNumberSize);
    }

    @Test
    void LottoTicket_1등_티켓_생성() {
        String winNumbers = "1, 2, 3, 4, 5, 6";
        int lottoNumberSize = 6;

        LottoTicket lottoTicket = new LottoTicket(winNumbers);
        assertThat(lottoTicket.size()).isEqualTo(lottoNumberSize);
    }
}
