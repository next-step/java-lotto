package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    public void create() {
        assertThat(LottoNumber.of("8")).isEqualTo(LottoNumber.of(8));
    }

    @Test
    public void create_hasSpace() {
        assertThat(LottoNumber.of("8 ")).isEqualTo(LottoNumber.of(8));
    }

    @Test
    public void create_재사용() {
        assertThat(LottoNumber.of("8") == LottoNumber.of(8)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_1보다_작은_값() {
        LottoNumber.of(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_45보다_큰_값() {
        LottoNumber.of(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_null() {
        LottoNumber.of(null);
    }
}
