package lottery.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceTest {

    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1000})
    @DisplayName("천원 보다 작은 값 테스트")
    void invalidValueTest(final int input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> PurchasePrice.of(input));
    }
}
