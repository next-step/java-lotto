package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("입력된 금액만큼 로또티켓을 구입하는 테스트")
    @Test
    void buy_ticket_from_input_price_test() {
        Lotto lotto = new Lotto(14000);
        assertThat(lotto.getTicketNum()).isEqualTo(14);
    }
}
