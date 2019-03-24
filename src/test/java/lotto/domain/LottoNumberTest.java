package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test(expected = RuntimeException.class)
    public void 로또_숫자로_0은_불가능한지() {

        LottoNumber.of(0);
    }

    @Test(expected = RuntimeException.class)
    public void 로또_숫자로_46은_불가능한지() {

        LottoNumber.of(46);
    }

    @Test
    public void 로또_숫자1_2개_비교() {

        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }
}