package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuyingAmountTest {

    @Test
    void 로또번호를_1000원_단위로_살_수_있다() {
        assertDoesNotThrow(() -> new BuyingAmount(14000));
    }

    @Test
    void 로또번호를_1000원_단위로_살_수_없다() {
        assertThrows(IllegalArgumentException.class, () -> new BuyingAmount(14500));
    }

    @Test
    void 나눗셈이_가능하다() {
        BuyingAmount buyingAmount = new BuyingAmount(1000);

        double actual = buyingAmount.divide(14000);
        double expected = 14;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 구매_가능한_로또_수를_알_수_있다() {
        BuyingAmount buyingAmount = new BuyingAmount(14000);

        int actual = buyingAmount.units();
        int expected = 14;

        assertThat(actual).isEqualTo(expected);
    }

}
