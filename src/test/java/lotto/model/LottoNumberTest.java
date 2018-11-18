package lotto.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    public void 생성() {
        assertThat(LottoNumber.from(1)).isEqualTo(LottoNumber.from(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_1미만() {
        LottoNumber.from(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_45초과() {
        LottoNumber.from(46);
    }

    @Test
    public void 생성_1() {
        assertThat(LottoNumber.from(1)).isEqualTo(LottoNumber.from(1));
    }

    @Test
    public void 생성_45() {
        assertThat(LottoNumber.from(45)).isEqualTo(LottoNumber.from(45));
    }

    @Test
    public void 인스턴스_재사용() {
        assertThat(LottoNumber.from(10) == LottoNumber.from(10)).isTrue();
    }

    @Test
    public void 값_1() {
        assertThat(LottoNumber.from(1).toString()).isEqualTo("1");
    }

    @Test
    public void 값_45() {
        assertThat(LottoNumber.from(45).toString()).isEqualTo("45");
    }
}