package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 숫자를 생성할 수 있다.")
    public void lottoNumberTest() {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
    }

    @Test
    @DisplayName("로또 숫자 범위인 1~45를 넘어가면 Exception이 발생한다.")
    public void lottoNumberValidTest() {
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
