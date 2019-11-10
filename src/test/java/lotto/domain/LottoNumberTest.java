package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 01:18
 */
public class LottoNumberTest {
    @Test
    void 생성() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }

    @Test
    void 범위_0() {
        assertThatThrownBy(() -> {
            LottoNumber.of(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_46() {
        assertThatThrownBy(() -> {
            LottoNumber.of(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
