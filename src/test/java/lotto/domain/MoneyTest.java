package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    private static final String STRING_MONEY = "14000";

    private Money money;

    @BeforeEach
    void setUp() {
        money = new Money(new BigInteger(STRING_MONEY));
    }

    @DisplayName("생성할때 ")
    @Nested
    class Create {

        @DisplayName("숫자 문자열로 생성한다.")
        @Test
        void string() {
            Money expected = money;
            Money actual = new Money(STRING_MONEY);

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("숫자가 아닌 문자열이면 예외가 발생한다.")
        @Test
        void not_number_string() {
            assertThatThrownBy(() -> new Money("14000원"))
                    .isExactlyInstanceOf(NotNumberStringException.class)
                    .hasMessage("숫자가 아닌 문자가 입력되었습니다.");
        }

        @DisplayName("0 이상의 수가 아니면 예외가 발생한다.")
        @Test
        void validate_zero_or_more() {
            assertThatThrownBy(() -> new Money(BigInteger.valueOf(-1)))
                    .isExactlyInstanceOf(NotZeroOrMoreNumberException.class)
                    .hasMessage("0이상의 수가 아닙니다.");
        }

    }

    @DisplayName("주어진 값의 이상인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,true", "999,false", "1001,true"})
    void equal_or_more_than(BigInteger value, boolean expected) {
        boolean actual = new Money(value).equalOrMoreThan(new Money(BigInteger.valueOf(1000)));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("뺄셈")
    @Test
    void subtract() {
        Money actual = money.subtract(new Money(BigInteger.valueOf(1000)));

        assertThat(actual).isEqualTo(new Money(BigInteger.valueOf(13000)));
    }

    @DisplayName("나눗셈")
    @Test
    void divide() {
        BigDecimal actual = money.divide(new Money(BigInteger.valueOf(7000)));

        assertThat(actual).isEqualTo(new BigDecimal("2.00"));
    }

    @DisplayName("곱셈")
    @Test
    void multiply() {
        Money actual = money.multiply(BigInteger.valueOf(2));

        assertThat(actual).isEqualTo(new Money(BigInteger.valueOf(28000)));
    }
}
