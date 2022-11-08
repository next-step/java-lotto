package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchasePriceTest {

    @Test
    void successTest() {
        assertThat(new PurchasePrice("10").getPurchasePrice())
                .isEqualTo(10);
    }

    @Test
    void failTest() {
        assertThatThrownBy(() -> new PurchasePrice("abc"))
                .isInstanceOf(NumberFormatException.class);
    }

}
