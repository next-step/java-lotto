package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoNoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_0_생성시_예외가_발생() {
        LottoNo.from(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_46_생성시_예외가_발생() {
        LottoNo.from(46);
    }

    @Test
    public void 로또번호_1_생성() {
        final LottoNo no1 = LottoNo.from(1);
        final LottoNo no2 = LottoNo.from(1);
        assertThat(no1).isEqualTo(no2);
    }

    @Test
    public void 로또번호_45_생성() {
        final LottoNo no1 = LottoNo.from(45);
        final LottoNo no2 = LottoNo.from(45);
        assertThat(no1).isEqualTo(no2);
    }

}