package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    @DisplayName("1등에 당첨된다.")
    void winnerTest() {
        //given
        int winningPrize = 2000000000;
        LottoTicket winningLotto = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicketGroup myLottoTickets = new LottoTicketGroup(Arrays.asList(winningLotto));
        Lotto lotto = new Lotto(winningLotto);

        //when then
        assertThat(lotto.compareLotto(myLottoTickets).sumMoney()).isEqualTo(winningPrize);
    }
}
