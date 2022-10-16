package lotto.domain;

import lotto.domain.exception.OutOfRangeLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("String 타입으로 생성할 수 있다.")
        @Test
        void string() {
            LottoNumber actual = new LottoNumber("1");

            assertThat(actual).isEqualTo(new LottoNumber(1));
        }

        @DisplayName("1~45 사이의 숫자가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        void validate_number_range(int value) {
            assertThatThrownBy(() -> new LottoNumber(value))
                    .isExactlyInstanceOf(OutOfRangeLottoNumberException.class)
                    .hasMessage("로또 숫자의 범위를 벗어난 숫자가 포함되어 있습니다. 유효한 로또 숫자 범위 : 1 ~ 45");
        }
    }
}
