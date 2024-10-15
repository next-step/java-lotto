package lotto.domain.ticket;

import lotto.application.AutoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 구매금액에 따른 티켓 수를 반환한다.")
    void 로또_구매금액에_따른_티켓_수() {
        Lotto lotto = new Lotto(new AutoGenerator());

        int lottoTicketCount = lotto.getLottoTicketCount(14000);
        int lottoTicketCountZero = lotto.getLottoTicketCount(500);

        Assertions.assertThat(lottoTicketCount).isEqualTo(14);
        Assertions.assertThat(lottoTicketCountZero).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 구입 티켓 수만큼 로또를 발행하여 반환한다.")
    void 로또_티켓_수만큼_로또_발행() {
        Lotto lotto = new Lotto(new AutoGenerator());

        LottoTickets issuedTickets = lotto.issue(10);

        Assertions.assertThat(issuedTickets.getLottoTicketsSize()).isEqualTo(10);
    }
}