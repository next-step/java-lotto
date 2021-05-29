package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private final int LOTTO_NUM = 14;
    LottoTicket lottoTicket = new LottoTicket(LOTTO_NUM);

    @Test
    void lottoList() {
        assertThat(lottoTicket.lottoList().size()).isEqualTo(LOTTO_NUM);
    }

}