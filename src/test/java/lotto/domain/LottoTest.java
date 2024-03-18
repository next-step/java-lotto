package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @Test
    @DisplayName("Ball 개수가 6개라면 정상적으로 생성된다")
    void new_success_for_between_1_45() {
        Set<Ball> balls = new HashSet<>();
        while (balls.size() < 6) {
            Ball ball = BallFactory.generate();
            balls.add(ball);
        }

        assertThatNoException()
            .isThrownBy(() -> new Lotto(balls));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 7})
    @DisplayName("Ball 개수가 6개가 아니라면 예외가 발생한다")
    void name(int size) {
        Set<Ball> balls = new HashSet<>();
        while (balls.size() < size) {
            Ball ball = BallFactory.generate();
            balls.add(ball);
        }

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(balls));
    }
}
