package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
    @Test
    @DisplayName("Ball.valueOf로 객체를 생성한다.")
    void create_Ball() {
        Ball ball = Ball.valueOf(1);
        assertThat(ball).isInstanceOf(Ball.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {Ball.MINIMUM_VALUE - 1, Ball.MAXIMUM_VALUE + 1})
    @DisplayName("로또 번호 범위를 벗어나면 예외가 발생한다.")
    void check_invalidLeftNumber_ExceptionThrown(int input) {
        assertThatThrownBy(() -> Ball.valueOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Ball.OUT_OF_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("Ball 객체는 동등성을 보장한다.")
    void equals_HasSameValue() {
        Ball ball1 = Ball.valueOf(Ball.MAXIMUM_VALUE);
        Ball ball2 = Ball.valueOf(Ball.MAXIMUM_VALUE);
        assertThat(ball1).isEqualTo(ball2);
    }

    @Test
    @DisplayName("Ball 객체는 동일성을 보장한다.")
    void identify_HasSameValue() {
        Ball ball1 = Ball.valueOf(Ball.MINIMUM_VALUE);
        Ball ball2 = Ball.valueOf(Ball.MINIMUM_VALUE);
        assertThat(ball1).isSameAs(ball2);
    }
}