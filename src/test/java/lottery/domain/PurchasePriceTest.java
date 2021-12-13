package lottery.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasePriceTest {

    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1000})
    @DisplayName("천원 보다 작은 값 테스트")
    void lessThanMininumPriceTest(final int input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> PurchasePrice.of(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1100, 1999})
    @DisplayName("천원 단위 테스트")
    void priceUnitTest(final int input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> PurchasePrice.of(input));
    }

}
