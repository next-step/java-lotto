package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("로또 넘버를 숫자를 인자로 생성하면 해당 숫자의 로또 넘버를 생성한다.")
    void getNumber() {
         assertThat(new LottoNumber(1).getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 넘버의 범위를 넘어가는 숫자를 인자로 생성하면, 예외가 발생한다.")
    void createWithOutOfBoundNumber() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
}