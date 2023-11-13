package src.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    @Test
    void 로또의_최소가격으로_로또를_구매할_수_있다() {
        LottoMachine lottoMachine = new LottoMachine();
        Money money = new Money(1000);

        List<Lotto> lottos = lottoMachine.buyLotto(money);

        assertThat(lottos).hasSize(1);
    }

    @Test
    void 로또의_최소_가격보다_적은_돈으로는_구매할_수_없다() {
        LottoMachine lottoMachine = new LottoMachine();
        Money money = new Money(0);
        int priceOfLotto = 1000;

        assertThatThrownBy(() -> lottoMachine.buyLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또의 가격은" + priceOfLotto + "원 입니다");
    }
}
