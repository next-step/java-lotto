package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ManualCountTest {

    @Test
    void 수동구매갯수가_금액으로_구입_할_수_있는_수량보다_많으면_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new ManualCount(5, new BuyingAmount(2000)));
    }

    @Test
    void 뺄샘이_가능하다() {
        ManualCount manualCount = new ManualCount(5, new BuyingAmount(10000));

        int actual = manualCount.minus(10);
        int expected = 5;

        assertThat(actual).isEqualTo(expected);
    }

}
