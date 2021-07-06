package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @DisplayName(value = "로또넘버 문자열로 바꾸기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void change_to_string(final int number) {
        assertThat(LottoNumber.of(number).toString()).isEqualTo(Integer.toString(number));
    }

    @DisplayName(value = "두 로또넘버는 같다.")
    @Test
    void both_lottonumber_is_same() {
        assertThat(LottoNumber.of(1).isSame(LottoNumber.of(1))).isTrue();
    }

    @DisplayName(value = "두 로또넘버는 다르다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    void both_lottonumber_is_different(final int number) {
        assertThat(LottoNumber.of(1).isSame(LottoNumber.of(number))).isFalse();
    }
}