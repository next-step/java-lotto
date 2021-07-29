package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @DisplayName("1-45 범위를 벗어나면 에러")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void validateValue_fail(int value) {
        assertThatThrownBy(() -> new LottoNumber(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1-45 범위의 숫자 입력시 성공")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void validateValue_success(int value) {
        assertThat(new LottoNumber(value));
    }
}