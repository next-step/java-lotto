package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("금액 테스트(0이상 입력)")
    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 3000})
    void 금액_0원이상(int input) {
        assertTrue(new Money(input).amount() >= 0);
    }

    @DisplayName("금액 테스트(음수값 입력)")
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, -3000})
    void 금액_음수(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(input))
                .withMessageMatching("금액은 음수일 수 없습니다.");
    }

    @DisplayName("금액 더하기(plus method 사용)")
    @Test
    void 금액_더하기() {
        Money money = new Money(10_000);
        Money other = new Money(1_000);

        assertThat(money.plus(other)).isEqualTo(new Money(11_000));
    }

    @DisplayName("금액 나누기(divide method 사용)")
    @Test
    void 금액_나누기() {
        Money money = new Money(10_000);
        Money other = new Money(1_000);

        assertThat(money.divide(other)).isEqualTo(10);
    }
}
