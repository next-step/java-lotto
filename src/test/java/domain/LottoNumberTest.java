package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("로또 숫자가 정상 범위일 때 test")
    void verifyInRange() {
        assertThatCode(()->new LottoNumber(3))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 숫자가 정상 범위가 아닐 때 test")
    void verifyOutRange() {
        assertThatThrownBy(()->new LottoNumber(99))
                .isInstanceOf(IllegalArgumentException.class);
    }
}