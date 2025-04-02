package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @DisplayName("로또 숫자 범위 테스트")
    @Test
    public void validateLottoNumber() throws Exception {
        assertThat(new LottoNumber(1))
                .isNotNull();

        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Lotto requires a number between ");

        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Lotto requires a number between ");
    }
}