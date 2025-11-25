package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber.value()).isEqualTo(1);
    }

    @Test
    void 로또의_범위는_1에서_45이다() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또 번호는 1부터 45입니다.");

    }
}
