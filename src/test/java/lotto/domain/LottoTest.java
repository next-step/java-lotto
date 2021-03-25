package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또 번호는 1과 45사이의 숫자여야 한다.")
    void lottoNumber(int param) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(param));
    }
}