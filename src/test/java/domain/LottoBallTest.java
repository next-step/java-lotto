package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoBallTest {

    @Test
    @DisplayName("같은 숫자를 재사용하는가")
    void ball() {
        LottoBall ball = LottoBall.ball(7);
        LottoBall ball2 = LottoBall.ball(7);
        assertSame(ball, ball2);
    }

    @Test
    void getNumber() {
        LottoBall number = LottoBall.ball(45);

        assertThat(number.getNumber()).isEqualTo(45);
    }
}