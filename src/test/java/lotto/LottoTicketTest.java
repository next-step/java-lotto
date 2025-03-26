package lotto;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    @DisplayName("구매한 로또 개수 구하기")
    void 구매_로또_개수_계산() {
        int money = 14000;
        LottoTicket lotto = new LottoTicket(money);

        assertThat(lotto.getCount()).isEqualTo(14);
    }


}