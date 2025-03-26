package step3;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumTest {

    @Test
    void create() {
        LottoNum lottoNum = new LottoNum(1);
        assertThat(lottoNum.getLottoNum()).isEqualTo(1);
    }

    @Test
    void 로또의_숫자는_1_45_사이() {
        assertThatThrownBy(() -> new LottoNum(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또의 숫자는 1 - 45 사이만 가능합니다.");

        assertThatThrownBy(() -> new LottoNum(46))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또의 숫자는 1 - 45 사이만 가능합니다.");
    }
}
