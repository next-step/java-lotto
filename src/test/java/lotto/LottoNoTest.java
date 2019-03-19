package lotto;

import lotto.vo.LottoNo;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {
    @Test
    public void 로또번호범위() {
        LottoNo lottoNo = new LottoNo(1);
        assertThat(lottoNo.getNumber()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호범위에러_최소값() {
        LottoNo lottoNo = new LottoNo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호범위에러_최대값() {
        LottoNo lottoNo = new LottoNo(46);
    }
}