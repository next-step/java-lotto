package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void range_between_1_and_45() {
        LottoNumber lottoNumber = LottoNumber.getInstance();
        assertThat(lottoNumber.getNumber()).isBetween(1, 45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception_out_of_range() {
        LottoNumber.getInstance(46);
    }

    @Test
    public void equals_when_number_same() {
        LottoNumber lottoNumber1 = LottoNumber.getInstance(1);
        LottoNumber lottoNumber2 = LottoNumber.getInstance(1);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }

    @Test
    public void reuse_when_number_same() {
        LottoNumber lottoNumber1 = LottoNumber.getInstance(1);
        LottoNumber lottoNumber2 = LottoNumber.getInstance(1);

        assertThat(lottoNumber1).isSameAs(lottoNumber2);
    }
}
