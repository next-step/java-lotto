package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    public void 랜덤숫자범위_1_45_아닐시_예외발생() {
        assertThatThrownBy(() -> LottoNumber.from(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1~45의 범위입니다.");

        assertThatThrownBy(() -> LottoNumber.from(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1~45의 범위입니다.");

    }

}