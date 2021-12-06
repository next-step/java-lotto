package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {

    @DisplayName("생성자 테스트")
    @Test
    void createTest() {
        assertThat(Money.of("1000")).isEqualTo(Money.of(1000));
        assertThat(Money.of("1000")).isEqualTo(Money.of(BigDecimal.valueOf(1000)));
    }

    @DisplayName("숫자 이외의 값이 오면 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"a", "한", "-", "/"})
    void notNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.of(input));
    }

    @DisplayName("null or empty 값이 오면 IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    void notEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.of(input));
    }

    @DisplayName("나누기를 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"5000:1000:5", "10000:1000:10"}, delimiter = ':')
    void devideTest(BigDecimal money, BigDecimal priceMoney, int expect) {
        Money myMoney = Money.of(money);
        Money price = Money.of(priceMoney);

        assertThat(myMoney.divide(price).intValue()).isEqualTo(expect);
    }
}
