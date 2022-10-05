package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    void of() {
        assertThat(LottoNumber.of(45)).isEqualTo(new LottoNumber(45));
    }

    @DisplayName("로또 숫자가 1이상 45이하가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create_exception(Integer number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}