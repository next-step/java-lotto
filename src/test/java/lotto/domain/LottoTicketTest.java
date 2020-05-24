package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void LottoTicket_생성() {
        LottoTicket lottoTicket = LottoTicket.create();

        int lottoNumberSize = 6;
        lottoTicket.printLottoNumbers();
        assertThat(lottoTicket.size()).isEqualTo(lottoNumberSize);
    }


}
