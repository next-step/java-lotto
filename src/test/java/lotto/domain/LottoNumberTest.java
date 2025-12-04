package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("같은 값을 가지면, 동일한 로또 번호이다")
    void init_equals() {
        assertThat(LottoNumber.from(45)).isEqualTo(LottoNumber.from(45));
    }

    @Test
    @DisplayName("로또번호는 1부터 45사이의 값을 가져야한다")
    void init_lottoNumber() {
        assertThatThrownBy(() -> LottoNumber.from(46)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.from(0)).isInstanceOf(IllegalArgumentException.class);
    }
}