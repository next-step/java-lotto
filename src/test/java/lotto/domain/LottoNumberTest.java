package lotto.domain;

import org.junit.Test;

public class LottoNumberTest {

    @Test(expected = RuntimeException.class)
    public void 로또_숫자로_0은_불가능한지() {
        LottoNumber lottoNumber = new LottoNumber(0);
    }

    @Test(expected = RuntimeException.class)
    public void 로또_숫자로_46은_불가능한지() {
        LottoNumber lottoNumber = new LottoNumber(46);
    }
}