package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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
    }
}
