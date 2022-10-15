package autoLotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class QuantityTest {

    @Test
    void quantity() {
        Quantity quantity = new Quantity(1000);

        assertThat(quantity.getQuantity()).isEqualTo(1);
    }

    @Test
    void 예외_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Quantity(10)
        );
    }
}
