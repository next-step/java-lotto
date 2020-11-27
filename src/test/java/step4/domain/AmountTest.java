package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    @ParameterizedTest
    @DisplayName("로또 구매 값 0인 경우 예외")
    @ValueSource(ints = {0})
    public void 로또_구매값_0원(int value) {
        assertThatThrownBy(() -> Amount.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액 값이 없습니다.");

    }

    @ParameterizedTest
    @DisplayName("로또 구매 값 1000원 이하인 경우 예외")
    @ValueSource(ints = {900, 200, 500})
    public void 로또_구매값_1000원이하(int value) {
        assertThatThrownBy(() -> Amount.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1000원부터 입력가능합니다.");

    }

    @ParameterizedTest
    @DisplayName("로또 구매 값 100000 이상인 경우 예외")
    @ValueSource(ints = {110000, 210000, 310000})
    public void 로또_구매값_100000원이상(int value) {
        assertThatThrownBy(() -> Amount.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 10만원 이상 구매불가합니다.");

    }
}
