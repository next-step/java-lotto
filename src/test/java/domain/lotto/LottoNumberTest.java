package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("1 ~ 45번호를 가진 로또번호를 생성할 수 있다.")
    @Test
    void create() {
        assertThat(LottoNumber.from(1)).isEqualTo(new LottoNumber(1));
        assertThat(LottoNumber.from(45)).isEqualTo(new LottoNumber(45));
    }

    @DisplayName("1~45번호가 아니면 예외를 던진다.")
    @Test
    void createWithException() {
        assertThatThrownBy(() -> LottoNumber.from(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.from(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
