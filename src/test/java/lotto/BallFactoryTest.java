package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Ball;
import lotto.domain.BallFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class BallFactoryTest {

    @RepeatedTest(100)
    @DisplayName("1~45 사이의 랜덤한 수를 가진 공을 생성한다")
    void generate() {
        Ball ball = BallFactory.generate();
        assertThat(ball.number()).isBetween(1, 45);
    }
}
