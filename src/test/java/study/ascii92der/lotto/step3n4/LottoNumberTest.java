package study.ascii92der.lotto.step3n4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 1-45 사이의 값인지 확인")
    void valid() {
        assertThatThrownBy(() -> new LottoNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.ERROR_MASSAGE_OUT_OF_RANGE_LOTTO_NUMBER);
    }
}