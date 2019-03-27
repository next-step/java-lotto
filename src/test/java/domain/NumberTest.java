package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_범위에_포함되지_않는_숫자_입력() {
        new Number(0);
        new Number(47);
    }

    @Test
    public void 숫자_일치여부_확인_일치할_때() {
        Number number = new Number(6);
        assertThat(number.equals(6)).isEqualTo(true);
    }

    @Test
    public void 숫자_일치여부_확인_불일치할_때() {
        Number number = new Number(7);
        assertThat(number.equals(6)).isEqualTo(false);
    }
}
