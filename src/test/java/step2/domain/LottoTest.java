package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 생성을 요청한다.")
    void lotto_make_test() {
        int money = 14000;
        Lotto lotto = new Lotto(money);

        assertThat(lotto.getTotalLottoTicketCount()).isEqualTo(14);
        assertThat(lotto.getLottoTickets().getLottoTickets().size()).isEqualTo(14);
    }
}