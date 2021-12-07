package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void shouldCreateSameObject() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void shouldThrowWhenInputNotInRange(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 숫자는 1 이상 45 이하여야 합니다.");
    }
}