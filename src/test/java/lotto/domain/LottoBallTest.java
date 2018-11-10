package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class LottoBallTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또볼_음수_번호_검증() {
        LottoBall ball = new LottoBall(-1);
        assertThat(ball.getNumber()).isEqualTo(1);
    }
    @Test
    public void 로또볼_1_번호_검증() {
        LottoBall ball = new LottoBall(1);
        assertThat(ball.getNumber()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또볼_46_번호_검증() {
        LottoBall ball = new LottoBall(46);
    }

    @Test
    public void 같은번호_로또볼_비교() {
        LottoBall ball1 = new LottoBall(5);
        LottoBall ball2 = new LottoBall(5);
        assertThat(ball1.equals(ball2)).isTrue();
    }

    @Test
    public void 다른번호_로또볼_비교() {
        LottoBall ball1 = new LottoBall(3);
        LottoBall ball2 = new LottoBall(5);
        assertThat(ball1.equals(ball2)).isFalse();
    }
}