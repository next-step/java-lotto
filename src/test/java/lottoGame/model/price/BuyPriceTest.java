package lottoGame.model.price;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BuyPriceTest {

    @Test
    void 로또_구매가격이_0이하면_예외처리를_할_수_있다() {
        assertThatThrownBy(
                () -> new BuyPrice(0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 개당_로또가격을_기반으로_발행해야하는_로또갯수를_계산할_수_있다() {
        assertThat(
                new BuyPrice(14000).calculateLottoCount(1000)
        ).isEqualTo(14);
    }
}