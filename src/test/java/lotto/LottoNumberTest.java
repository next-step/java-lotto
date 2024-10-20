package lotto;

import lotto.lotto.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void 로또번호_벨리데이션() {
        assertThatThrownBy(() -> {LottoNumber lottoNumber = new LottoNumber(46);}).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {LottoNumber lottoNumber = new LottoNumber(0);}).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {LottoNumber lottoNumber = new LottoNumber(-1);}).isInstanceOf(IllegalArgumentException.class);
    }

}

