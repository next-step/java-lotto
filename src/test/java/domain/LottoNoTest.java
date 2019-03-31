package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {

    @Test
    public void 로또_생성() {
        assertThat(LottoNo.of(45).equals(LottoNo.of(45))).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_범위_초과() {
        LottoNo.of(46);
    }

}
