package domain;

import org.junit.Test;

public class LottoNoTest {

    @Test(expected = RuntimeException.class)
    public void 로또번호_1이하의_값은_예외처리한다() {
        new LottoNo(0);
    }

    @Test(expected = RuntimeException.class)
    public void 로또번호_45이상의_값은_예외처리한다() {
        new LottoNo(0);
    }

}