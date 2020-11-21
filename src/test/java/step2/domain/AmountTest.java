package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    @ParameterizedTest
    @DisplayName("로또 구매 값 0인 경우 예외")
    @ValueSource(ints = {0})
    public void 로또_구매값_0원(int value) {
        assertThatThrownBy(() ->  new Amount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액 값이 없습니다.");

    }

    @ParameterizedTest
    @DisplayName("로또 구매 값 1000원 이하인 경우 예외")
    @ValueSource(ints = {100, 200, 500})
    public void 로또_구매값_1000원이하(int value) {
        assertThatThrownBy(() ->  new Amount(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 1000원부터 입력가능합니다.");

    }
}
