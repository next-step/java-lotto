package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    void input_zero() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_fifty() {
        assertThatThrownBy(() -> new LottoNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void input_fifty_one() {
        assertThatThrownBy(() -> {
            new LottoNumber(51);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자 범위를 벗어났습니다.");
    }
}