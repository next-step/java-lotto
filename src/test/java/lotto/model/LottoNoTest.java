package lotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호_1미만() {
        LottoNo.from(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호_45초과() {
        LottoNo.from(46);
    }

    @Test
    public void 로또_번호_입력() {
        LottoNo lottoNo = LottoNo.from(5);
        LottoNo lottoNo1 = LottoNo.from(5);

        assertThat(lottoNo).isEqualTo(lottoNo1);
    }

}