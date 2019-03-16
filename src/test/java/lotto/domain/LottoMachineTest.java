package lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {
    @Test
    public void 입력값_만큼_로또_가져오기() {
        // given
        int numberOfLottos = 5;

        // when
        List<Lotto> lottos = LottoMachine.getLottos(5);

        // then
        assertThat(lottos).hasSize(numberOfLottos);
    }

    @Test
    public void 금액_만큼_로또를_구매하기_잔액없는경우() {
        // given
        int money = 10_000;

        // when
        List<Lotto> lottos = LottoMachine.buyLottos(money);

        // then
        assertThat(lottos).hasSize(10);
    }

    @Test
    public void 금액_만큼_로또를_구매하기_잔액있는경우() {
        // given
        int money = 10_500;

        // when
        List<Lotto> lottos = LottoMachine.buyLottos(money);

        // then
        assertThat(lottos).hasSize(10);
    }

    @Test
    public void 금액이_음수인_경우_IllegalArgumentException() {
        // given
        int money = -1_000;

        //when
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoMachine.buyLottos(money));
    }
}
