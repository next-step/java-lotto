package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호는 1 ~ 45사이 아닌 숫자 예외")
    @ValueSource(ints = {46, 47, 99, -1})
    public void 로또_번호_45이상_숫자(Integer lottoNumbers) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 ~ 45사이의 숫자여야 합니다.");
    }
}
