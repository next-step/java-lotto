package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    
    @Test
    public void 로또번호_정상_생성() {
        LottoNumber lottoNumber = new LottoNumber(4);

        assertThat(lottoNumber.getNumber()).isEqualTo(4);
    }

    @Test
    public void 로또번호_범위_벗어남() {
        assertThatThrownBy(() -> new LottoNumber(0))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumber(46))
            .isInstanceOf(IllegalArgumentException.class);
    }
}