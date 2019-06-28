package domain;

import org.junit.Test;

public class WinningLottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호는_보너스번호와_중복되지않는다() {
        new WinningLotto(new LottoSet(1, 2, 3, 4, 5, 6), new LottoNumber(1));
    }
}