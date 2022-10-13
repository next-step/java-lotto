package lotto.domain;

import lotto.domain.exception.NotNumberStringException;
import lotto.domain.exception.NotZeroOrMoreNumberException;
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
            Money actual = new Money(STRING_MONEY);

            assertThat(actual).isEqualTo(money);
        }

        @DisplayName("정수형으로 생성한다.")
        @Test
        void integer() {
            Money actual = new Money(14000);

            assertThat(actual).isEqualTo(money);
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
            assertThatThrownBy(() -> new Money(-1))
                    .isExactlyInstanceOf(NotZeroOrMoreNumberException.class)
                    .hasMessage("0이상의 수가 아닙니다.");
        }

    }

    @DisplayName("주어진 값의 미만인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,false", "999,true", "1001,false"})
    void equal_or_more_than(BigInteger value, boolean expected) {
        boolean actual = new Money(value).lessThan(new Money(1000));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("파라미터로 입력된 만큼의 돈을 빼서 반환한다.")
    @Test
    void subtract() {
        Money actual = money.subtract(new Money(1000));

        assertThat(actual).isEqualTo(new Money(13000));
    }

    @DisplayName("파라미터로 입력된 만큼 나눠 소수점 둘째 이후 값은 버리고 BigDecimal 타입으로 반환한다.")
    @Test
    void divide() {
        BigDecimal actual = money.divide(new Money(7000));

        assertThat(actual).isEqualTo(new BigDecimal("2.00"));
    }

    @DisplayName("파라미터로 입력된 만큼 곱해서 돈을 반환한다.")
    @Test
    void multiply() {
        Money actual = money.multiply(new BigInteger("2"));

        assertThat(actual).isEqualTo(new Money(28000));
    }
}
