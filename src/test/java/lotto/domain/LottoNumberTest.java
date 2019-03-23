package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test(expected = RuntimeException.class)
    public void 로또_숫자로_0은_불가능한지() {
        new LottoNumber(0);
    }

    @Test(expected = RuntimeException.class)
    public void 로또_숫자로_46은_불가능한지() {
        new LottoNumber(46);
    }

    @Test
    public void 로또_숫자가_1에서_45사이_발급되는지() {
        assertThat(new LottoNumber().getValue()).isBetween(1, 45);
    }
}