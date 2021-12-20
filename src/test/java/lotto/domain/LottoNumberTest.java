package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호는 1에서 45사이 숫자만 가능하다")
    @ValueSource(strings = {"abc", "0", "46"})
    @ParameterizedTest
    void from(String number) {
        assertThatThrownBy(() -> LottoNumber.from(number)).isInstanceOf(LottoException.class);
    }
}
