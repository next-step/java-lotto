package lottoGame.model.lotto;

import static lottoGame.controller.LottoStore.PER_LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import lottoGame.model.price.BuyPrice;
import org.junit.jupiter.api.Test;

class LottoMachineTest {


    @Test
    void 사용자의금액만큼_로또를_발행할_수_있다() {
        LottoMachine lottoMachine = new LottoMachine(1000);
        BuyPrice buyPrice = new BuyPrice(14000);
        Lottos lotto = lottoMachine.publish(buyPrice);

        assertThat(
                lotto.size()
        ).isEqualTo(
                buyPrice.calculateLottoCount(PER_LOTTO_PRICE)
        );
    }
}