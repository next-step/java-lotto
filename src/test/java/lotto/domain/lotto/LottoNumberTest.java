package lotto.domain.lotto;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @DisplayName("LottoNumber의 생성자는")
    @Nested
    class Describe_constructor {

        @DisplayName("1과 45사이의 숫자를 입력할 경우, 해당 값을 가진다.")
        @Test
        void it_has_parameter_value_when_in_range() {
            final LottoNumber lottoNumber = new LottoNumber(7);
            assertThat(lottoNumber.value()).isEqualTo(7);
        }

        @DisplayName("1과 45사이가 아닌 숫자를 입력할 경우, IllegalArgumentException을 던진다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 47})
        void it_throws_illegalArgumentException_when_not_in_range(int input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new LottoNumber(input));
        }

        @DisplayName("1과 45사이의 숫자 문자열을 입력할 경우, 해당 값을 가진다.")
        @Test
        void it_has_parameter_value_when_in_range_string_number() {
            final LottoNumber lottoNumber = new LottoNumber("7");
            assertThat(lottoNumber.value()).isEqualTo(7);
        }

        @DisplayName("숫자가 아닌 문자열을 입력할 경우, NumberFormatException을 던진다.")
        @Test
        void it_throws_numberFormatException_when_not_number_string() {
            assertThatThrownBy(() -> new LottoNumber("asdf"))
                    .isInstanceOf(NumberFormatException.class);
        }
    }
}
