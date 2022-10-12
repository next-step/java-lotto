package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    private static final String STRING_MONEY = "14000";

    @DisplayName("생성할때 ")
    @Nested
    class Create {

        @DisplayName("숫자 문자열로 생성한다.")
        @Test
        void string() {
            Money expected = new Money(new BigInteger(STRING_MONEY));
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

    @DisplayName("천 단위인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000,true", "999,false", "0,false"})
    void is_Thousand_units(BigInteger value, boolean expected) {
        boolean actual = new Money(value).isThousandUnits();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("단위로 나눈 수를 반환한다.")
    @Test
    void divide_by_units() {
        BigInteger actual = new Money(BigInteger.valueOf(14000)).divideBy(BigInteger.valueOf(1000));

        assertThat(actual).isEqualTo(14);
    }
}
