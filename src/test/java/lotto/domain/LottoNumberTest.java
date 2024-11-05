package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 로또번호_생성() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    void 로또번호_최솟값_검증() {
        assertThatThrownBy(() -> {
            new LottoNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_최댓값_검증() {
        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
