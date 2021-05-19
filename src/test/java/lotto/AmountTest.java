package lotto;

import lotto.domain.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AmountTest {
    @ParameterizedTest
    @ValueSource(ints = {-1000, 0})
    @DisplayName("금액은 음수 또는 0원이면 안된다")
    public void 금액은_음수_또는_0원이면_안된다(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Amount(amount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 1000})
    @DisplayName("금액은 양수이면 된다.")
    public void 금액은_양수이면_안된다(int amount) {
        assertDoesNotThrow(() -> new Amount(amount));
    }

    @ParameterizedTest
    @CsvSource(value = {"14000,1000,14", "13500,1000,13", "12001,1000,12"}, delimiter = ',')
    @DisplayName("숫자를 누눌 수 있다")
    public void 숫자를_나눌_수_있다(int source, int dest, int except) {
        Amount total = new Amount(source);
        Amount target = new Amount(dest);

        assertThat(total.divide(target))
                .isEqualTo(except);
    }

    @Test
    @DisplayName("Amount와 숫자를 곱할 수 있다")
    public void Amount와_숫자를_곱할_수_있다() {
        Amount amount = new Amount(5000);

        assertThat(amount.multiple(5))
                .isEqualTo(new Amount(5000 * 5));
    }
}
