package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PriceTest {

    @ParameterizedTest
    @ValueSource(ints = {-10, -2341, -1})
    @DisplayName("금액은 0원이상 이어야 한다.")
    void validatePrice_test(int price) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Price(price));
    }
}
