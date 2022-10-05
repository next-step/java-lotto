package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @DisplayName("로또 숫자는 1 ~ 45 사이 값이 아니면 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void error_create_lotto_number(final int input) {

        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 1 ~ 45 사이여야 합니다.");
    }

    @DisplayName("로또 숫자는 1 ~ 45 사이인 경우 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create_lotto_number(final int input) {

        final Number number = new Number(input);

        assertThat(number.getNumber()).isEqualTo(input);
    }

    @DisplayName("로또 번호는 숫자만 생성가능하다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "?", "%"})
    void error_bonus_number(final String number) {

        assertThatThrownBy(() -> Number.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해야 합니다.");
    }
}
