package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PositiveIntegerTest {
    @ParameterizedTest
    @ValueSource(ints = {-1000})
    @DisplayName("양수숫자는 음수면 안된다")
    public void 양수숫자는은_음수면_안된다(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PositiveInteger(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000})
    @DisplayName("양수숫자는 양수이면 된다.")
    public void 양수숫자는_양수이면_안된다(int amount) {
        assertDoesNotThrow(() -> new PositiveInteger(amount));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,1000,14", "13500,1000,13", "12001,1000,12"}, delimiter = ',')
    @DisplayName("양수숫자는 누눌 수 있다")
    public void 양수숫자는_나눌_수_있다(int source, int dest, int except) {
        PositiveInteger total = new PositiveInteger(source);
        PositiveInteger target = new PositiveInteger(dest);

        assertThat(total.divide(target))
                .isEqualTo(new PositiveInteger(except));
    }

    @Test
    @DisplayName("양수숫자는 양수숫자와 곱할 수 있다")
    public void Amount와_숫자를_곱할_수_있다() {
        PositiveInteger positiveInteger = new PositiveInteger(5000);

        assertThat(positiveInteger.multiple(new PositiveInteger(5)))
                .isEqualTo(new PositiveInteger(5000 * 5));
    }

    @Test
    @DisplayName("양수숫자와 양수숫자는 더할 수 있다")
    public void 양수숫자와_양수숫자는_더할_수_있다() {
        PositiveInteger zero = new PositiveInteger(0);
        PositiveInteger target = new PositiveInteger(1000);

        assertThat(zero.plus(target))
                .isEqualTo(new PositiveInteger(1000));
    }
}
