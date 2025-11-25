package lottoGame.model.lotto;

import static lottoGame.controller.LottoStore.PER_LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

//    @Test
//    void 요청받은_갯수만큼_로또번호목록을_생성할_수_있다() {
//        assertThat(
//                new LottoMachine(1000).createLottoByCount(6).size()
//        ).isEqualTo(6);
//    }
//
//    @Test
//    void 요청받은_갯수가_0이하면_예외처리_할_수_있다() {
//        assertThatThrownBy(
//                () -> new LottoMachine(1000).createLottoByCount(0)
//        ).isInstanceOf(IllegalArgumentException.class);
//    }
}