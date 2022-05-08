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
        LottoTicket winningLotto = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        LottoTicketGroup myLottoTickets = new LottoTicketGroup(Arrays.asList(winningLotto));
        Lotto lotto = new Lotto(winningLotto);

        //when then
        assertThat(lotto.compareLotto(myLottoTickets).sumMoney()).isEqualTo(winningPrize);
    }
}
