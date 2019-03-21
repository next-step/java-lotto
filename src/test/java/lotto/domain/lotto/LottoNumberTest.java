package lotto.domain.lotto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 음수로_생성시_에러() {
        LottoNumber lottoNumber = new LottoNumber(-1);

    }

    @Test
    public void 생성후_값_가져오기() {
        LottoNumber lottoNumber = new LottoNumber(3);

        assertThat(lottoNumber.toString()).isEqualTo("3");
    }

    @Test
    public void 객체_일치() {
        LottoNumber lottoNumber1 = new LottoNumber(3);
        LottoNumber lottoNumber2 = new LottoNumber(3);

        assertEquals(lottoNumber1, lottoNumber2);
    }
}
