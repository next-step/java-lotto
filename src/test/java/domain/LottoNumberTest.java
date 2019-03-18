package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void range_between_1_and_45() {
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getNumber()).isBetween(1, 45);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exception_out_of_range() {
        new LottoNumber(46);
    }

    @Test
    public void equals_if_number_same() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(1);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }
}
