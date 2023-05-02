package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PriceTest {

    @Test
    @DisplayName("금액은 음수일 수 없다")
    public void nonNegative() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Price(-1)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,0,1000", "500,500,0", "2000,1000,1000"})
    @DisplayName("금액을 뺄 수 있다")
    public void minus(int num1, int num2, int result) {
        Price price1 = new Price(num1);
        Price price2 = new Price(num2);

        Price resultPrice = price1.minus(price2);

        assertThat(resultPrice).isEqualTo(new Price(result));
    }
}