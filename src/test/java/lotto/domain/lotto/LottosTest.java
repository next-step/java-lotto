package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.TicketDealer;
import lotto.domain.machine.RandomLottoGenerator;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    public void 입력한_티켓의개수만큼_로또가_생성된다() {
        //given
        Lottos lottos = TicketDealer.getLottosOf(new RandomLottoGenerator(), 14);

        //when

        //then
        assertThat(lottos.getLottosSize()).isEqualTo(14);
    }
}
