package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBallTest {

    @Test
    public void 로또_숫자_확인() {
        LottoBall lottoBall = new LottoBall(1);
        assertThat(lottoBall.number).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_최소숫자_미만_에러() {
        LottoBall lottoBall = new LottoBall(0);
        assertThat(lottoBall.number).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_최대숫자_초과_에러() {
        LottoBall lottoBall = new LottoBall(46);
        assertThat(lottoBall.number).isEqualTo(46);
    }

    @Test
    public void 숫자일치여부_확인() {
        LottoBall ball1 = new LottoBall(1);
        LottoBall ball2 = new LottoBall(2);
        assertThat(ball1.equals(ball2)).isEqualTo(false);
    }
}
