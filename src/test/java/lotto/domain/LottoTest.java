package lotto.domain;

import lotto.pattern.TestNumberGenerator;
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
        LottoNumber bonusNumber = new LottoNumber(7);
        Lotto lotto = new Lotto(new WinningLotto(winningLotto, bonusNumber));

        //when then
        assertThat(lotto.compareLotto(myLottoTickets).sumMoney()).isEqualTo(winningPrize);
    }

    @Test
    @DisplayName("2등에 당첨된다.")
    void second() {
        //given
        int secondWinningPrize = 30000000;
        LottoTicket winningLotto = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(7)
        ));
        LottoNumber bonusNumber = new LottoNumber(6);
        LottoTicketGroup myLottoTickets = new LottoTicketGroup(1000, new TestNumberGenerator());
        Lotto lotto = new Lotto(new WinningLotto(winningLotto, bonusNumber));

        assertThat(lotto.compareLotto(myLottoTickets).sumMoney()).isEqualTo(secondWinningPrize);
    }
}
