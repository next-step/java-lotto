package step3;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(1);
    }

    @Test
    void 로또의_숫자는_1_45_사이() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또의 숫자는 1 - 45 사이만 가능합니다.");

        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또의 숫자는 1 - 45 사이만 가능합니다.");
    }
}
