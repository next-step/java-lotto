package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.TicketDealer;
import lotto.domain.machine.RandomLottoGenerator;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    public void 수동으로_입력한_티켓의개수만큼_로또가_생성된다() {
        //given
        Lottos lottos = TicketDealer.getLottosByManual(Arrays.asList(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(2, 3, 4, 5, 6, 7)));

        //when

        //then
        assertThat(lottos.getLottosSize()).isEqualTo(2);
    }

    @Test
    public void 자동생성시_기존에_만들어진_로또에_개수가_그만큼_더해진다() {
        //given
        Lottos lottos = TicketDealer.getLottosByManual(Arrays.asList(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(2, 3, 4, 5, 6, 7)));
        List<Lotto> autoLottos = TicketDealer.getLottosByAuto(lottos, new RandomLottoGenerator(), 5);

        //when
        lottos.appendLottos(autoLottos);

        //then
        assertThat(lottos.getLottosSize()).isEqualTo(7);
    }
}
