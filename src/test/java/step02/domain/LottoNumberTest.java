package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또의 생성한 번호가 1~45 범위를 벗어난 경우 에러 발생")
    void validateIsBetween(int n) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(n));
    }
}