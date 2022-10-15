package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {-3, -100})
    @DisplayName("0 미만의 숫자로 Money 객체를 생성할 수 없다.")
    void create_withUnderZero(int value) {
        assertThatThrownBy(() -> new Money(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0 미만의 숫자는 허용되지 않습니다.");
    }

    @Test
    @DisplayName("countMaxNumberOfItemToBuy 메소드는 주어진 가격의 물건의 최대 구매 가능 개수를 계산한다.")
    void countMaxNumberOfItemToBuy() {
        assertThat(new Money(12500).countMaxNumberOfItemToBuy(1000)).isEqualTo(12);
    }
}
