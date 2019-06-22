package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Ball.MAX_NUMBER;
import static lotto.Ball.MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BallTest {

    @DisplayName("볼을 생성하는데 성공한다.")
    @Test
    void createBallSuccess() {
        Ball ball = Ball.of(1);
        assertThat(ball).isNotNull();
        assertThat(ball).isEqualTo(Ball.of(1));
    }

    @DisplayName("볼이 " + MIN_NUMBER + "보다 작을 경우 exception")
    @Test
    void createMinLessThanBallThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ball.of(MIN_NUMBER - 1))
                .withMessageMatching(String.format("볼은 %d ~ %d 사이의 숫자만 생성가능합니다.", MIN_NUMBER, MAX_NUMBER));
    }

    @DisplayName("볼이 " + MAX_NUMBER + "보다 큰 경우 exception")
    @Test
    void createMaxGreaterThanBallThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ball.of(MAX_NUMBER + 1))
                .withMessageMatching(String.format("볼은 %d ~ %d 사이의 숫자만 생성가능합니다.", MIN_NUMBER, MAX_NUMBER));
    }
}
