package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("1 ~ 45번호를 가진 로또번호를 생성할 수 있다.")
    @Test
    void create() {
        assertThat(LottoNumber.create(1)).isEqualTo(new LottoNumber(1));
        assertThat(LottoNumber.create(45)).isEqualTo(new LottoNumber(45));
    }

    @DisplayName("1~45번호가 아니면 예외를 던진다.")
    @Test
    void createWithException() {
        assertThatThrownBy(() -> LottoNumber.create(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.create(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
