package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    @DisplayName("로또 숫자는 1 ~ 45 이다. 그 이외의 숫자는 IllegalArgumentException 이다.")
    void lottoNumberBoundTest_ThrowsException(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
