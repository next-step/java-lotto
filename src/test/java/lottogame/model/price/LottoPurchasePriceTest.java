package lottogame.model.price;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.Test;

class LottoPurchasePriceTest {

    @Test
    void 로또_구매가격이_0이하면_예외처리를_할_수_있다() {
        assertThatThrownBy(
                () -> new LottoPurchasePrice(0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 개당_로또가격을_기반으로_발행해야하는_로또갯수를_계산할_수_있다() {
        assertThat(
                new LottoPurchasePrice(14000).calculateLottoCount(1000)
        ).isEqualTo(14);
    }

    @Test
    void 총상금으로_구매가격에비해_수익률이_얼마인지_계산할_수_있다() {
        assertThat(
                new LottoPurchasePrice(14000).calculateRateOfReturn(5000)
        ).isCloseTo(0.35, within(0.01));
    }
}