package lottogame.model.lotto;

import static lottogame.model.lotto.LottoMachine.PER_LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Set;
import lottogame.model.price.LottoPurchasePrice;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 사용자의금액만큼_로또를_발행할_수_있다() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(14000);
        Lottos lotto = lottoMachine.publish(lottoPurchasePrice);

        assertThat(
                lotto.size()
        ).isEqualTo(
                lottoPurchasePrice.calculateLottoCount(PER_LOTTO_PRICE)
        );
    }

    @Test
    void 요청받은_갯수만큼_로또번호목록을_생성할_수_있다() {
        assertThat(
                new LottoMachine().createLottoByNums(Set.of(1, 2, 3, 4, 5, 6)).size()
        ).isEqualTo(6);
    }

    @Test
    void 요청받은_갯수가_0이하면_예외처리_할_수_있다() {
        assertThatThrownBy(
                () -> new LottoMachine().createLottoByNums(Set.of())
        ).isInstanceOf(IllegalArgumentException.class);
    }
}