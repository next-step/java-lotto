package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test(expected = IllegalArgumentException.class)
    public void _1이상_45이하의_숫자가_아니면_예외가_발생한다() {
        LottoNumber.of(46);
    }

    @Test
    public void 같은_번호를_가지면_두_객체는_같다() {
        LottoNumber lottoNumber1 = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(1);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }

    @Test
    public void 같은_번호를_가지면_같은_객체를_리턴한다() {
        LottoNumber lottoNumber1 = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(1);

        assertThat(lottoNumber1).isSameAs(lottoNumber2);
    }

    @Test
    public void 크기를_비교한다() {
        LottoNumber lottoNumber1 = LottoNumber.of(10);
        LottoNumber lottoNumber2 = LottoNumber.of(20);

        assertThat(lottoNumber1.compareTo(lottoNumber2)).isEqualTo(-1);
    }
}
