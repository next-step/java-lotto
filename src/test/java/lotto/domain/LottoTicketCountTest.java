package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketCountTest {

    @Test
    @DisplayName("구매한 전체 로또 티켓 갯수 확인")
    void total_lotto_ticket_count_test() {
        // given
        LottoMoney lottoMoney = new LottoMoney(14000);

        // when
        LottoTicketCount lottoTicketCount = new LottoTicketCount.Builder()
                .lottoMoney(lottoMoney)
                .build();

       // then
        assertThat(lottoTicketCount.getAutoLottoTicketCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("구매한 자동/수동 로또 티켓 갯수 확인")
    void lotto_ticket_count_test() {
        // given
        LottoMoney lottoMoney = new LottoMoney(14000);

        // when
        LottoTicketCount lottoTicketCount = new LottoTicketCount.Builder()
                .lottoMoney(lottoMoney)
                .manualLottoCount(4)
                .build();

        // then
        assertThat(lottoTicketCount.getAutoLottoTicketCount()).isEqualTo(10);
        assertThat(lottoTicketCount.getManualLottoTicketCount()).isEqualTo(4);
    }

}
